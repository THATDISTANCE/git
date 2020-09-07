package com.atguigu.bigdata.sql.sql05

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.kafka.clients.consumer.{ConsumerConfig, ConsumerRecord}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable.ListBuffer

object Test01 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")
    val ssc = new StreamingContext(conf,Seconds(3))

    val kafkaMap = Map[String,Object](
      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG->"hadoop102:9092,hadoop103:9092,hadoop104:9092",
      ConsumerConfig.GROUP_ID_CONFIG->"atguigu",
      ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG->"org.apache.kafka.common.serialization.StringDeserializer",
      ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG->"org.apache.kafka.common.serialization.StringDeserializer"
    )

    val value: InputDStream[ConsumerRecord[String, String]] = KafkaUtils.createDirectStream(
      ssc,
      LocationStrategies.PreferConsistent,
      ConsumerStrategies.Subscribe[String,String](
        Set("sgg0421"),
        kafkaMap
      )
    )

    val lineSc = value.map(record=>record.value())

    lineSc.print()

    val adClickDs = lineSc.map(
      data=>{
        val datas = data.split(" ")
        AdClickData(datas(0),datas(1),datas(2),datas(3),datas(4))
      }
    )


    val adClickSumDs = adClickDs.transform(
      rdd => {
        val conn = JDBCUtils.getConnection()
        val stat = conn.prepareStatement("select id from black_list")
        val rs = stat.executeQuery()
        val black_list = ListBuffer[String]()
        while (rs.next()) {
          black_list.append(rs.getString(1))
        }
        rs.close()
        stat.close()
        conn.close()

        val filRdd = rdd.filter(
          data => {
            !black_list.contains(data.userid)
          }
        )

        filRdd.map(
          data => {
            val ff = new SimpleDateFormat("yyyy-MM-dd")
            val date = ff.format(new Date(data.ts.toLong))
            ((date, data.userid, data.adid), 1)
          }
        ).reduceByKey(_ + _)

      }
    )

    adClickSumDs.foreachRDD(
      rdd=>{
        rdd.foreachPartition(
          rdd=>{
            val conn = JDBCUtils.getConnection()
            rdd.foreach{
              case ((day,userid,adid),sum)=>{


                if( sum >= 10 ){
                  val stat1 = conn.prepareStatement(
                    """
                      |select id
                      |from black_list
                      |where id = ?
                      |""".stripMargin)

                  stat1.setInt(1,userid.toInt)
                  val rs1 = stat1.executeQuery()

                  if( rs1.next() ){

                  }else{
                    val stat2 = conn.prepareStatement(
                      """
                        |insert into
                        |`black_list` ( id )
                        |values(?)
                        |""".stripMargin)

                    stat2.setInt(1,userid.toInt)

                    stat2.executeUpdate()

                    stat2.close()
                  }

                }else{
                  val stat3 = conn.prepareStatement(
                    """
                      |select dt , userid , adid , count
                      |from `user_ad_count`
                      |where dt = ? and userid = ? and adid = ?
                      |""".stripMargin)

                  stat3.setString(1,day)
                  stat3.setString(2,userid)
                  stat3.setString(3,adid)

                  val rs3 = stat3.executeQuery()

                  var newsum = 0

                  if( rs3.next() ){

                    newsum = sum + rs3.getInt(4)

                    if( newsum >= 10 ){
                      val stat4 = conn.prepareStatement(
                        """
                          |select id
                          |from black_list
                          |where id = ?
                          |""".stripMargin)
                      stat4.setInt(1,userid.toInt)

                      val rs4 = stat4.executeQuery()

                      if ( rs4.next() ){

                      }else{
                        val stat5 = conn.prepareStatement(
                          """
                            |insert into
                            |`black_list` ( id )
                            |values (?)
                            |""".stripMargin)

                        stat5.setInt(1,userid.toInt)

                        stat5.executeUpdate()
                      }
                    }else{
                      val stat6 = conn.prepareStatement(
                        """
                          |update `user_ad_count`
                          |set count = ?
                          |where dt = ? and userid = ? and adid = ?
                          |""".stripMargin
                      )

                      stat6.setInt(1,newsum)
                      stat6.setString(2,day)
                      stat6.setString(3,userid)
                      stat6.setString(4,adid)

                      stat6.executeUpdate()
                    }


                  }else{
                    newsum = sum
                    val stat7 = conn.prepareStatement(
                      """
                        |insert into `user_ad_count`
                        |(dt , userid , adid , count) values (?,?,?,?)
                        |""".stripMargin)
                    stat7.setString(1,day)
                    stat7.setString(2,userid)
                    stat7.setString(3,adid)
                    stat7.setInt(4,newsum)

                    stat7.executeUpdate()
                  }
                }
              }
            }
          }
        )
      }
    )


    ssc.start()
    ssc.awaitTermination()

  }

  case class AdClickData(var ts:String,var area:String,var city:String,var userid:String,var adid:String)

}
