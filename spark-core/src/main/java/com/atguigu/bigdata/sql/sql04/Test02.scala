package com.atguigu.bigdata.sql.sql04

import org.apache.spark.SparkConf
import org.apache.spark.sql.{Encoder, Encoders, SparkSession, functions}
import org.apache.spark.sql.expressions.Aggregator

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Test02 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("hive")
    val spark = SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()

    spark.sql("use sgg200421").show()

    val udaf = new cityRemarkUdaf

    spark.udf.register("remark",functions.udaf(udaf))

    spark.sql(
      """
        |select *
        |from
        |(select
        |	* ,
        |	rank() over(partition by area order by clickCount desc) rank
        |from
        |(select
        |	area ,
        |	product_name ,
        |	count(*) as clickCount ,
        | remark(city_name)
        |from(
        |	select
        |		u.* ,
        |		c.area ,
        |		c.city_name ,
        |		p.product_name
        |	from user_visit_action as u
        |	join city_info c on u.city_id = c.city_id
        |	join product_info P on u.click_product_id = p.product_id
        |	where click_product_id != -1
        |) t1
        |group by area , product_name) t2) t3
        |where rank < 4
        |""".stripMargin).show()



    spark.stop()
  }

  case class Buff(var cnt:Long,var cityMap:mutable.Map[String,Int])
  class cityRemarkUdaf extends Aggregator[String,Buff,String]{

    override def zero: Buff = {
      Buff(0l,mutable.Map[String,Int]())
    }

    override def reduce(b: Buff, a: String): Buff = {
      b.cnt += 1
      val newCnt = b.cityMap.getOrElse(a,0)+1
      b.cityMap.update(a,newCnt)
      b
    }

    override def merge(b1: Buff, b2: Buff): Buff = {
      b2.cnt += b1.cnt
      val map1 = b1.cityMap
      val map2 = b2.cityMap
      b2.cityMap = map1.foldLeft(map2){
        case (map2,kv)=>{
          val sumCnt = map2.getOrElse(kv._1,0)+kv._2
          map2.update(kv._1,sumCnt)
          map2
        }
      }
      b2
    }

    override def finish(buff: Buff): String = {

      val sum = buff.cnt
      val map: mutable.Map[String, Int] = buff.cityMap
      val list = ListBuffer[String]()

      val presecond = map.toList.sortWith {
        case (left, right) => {
          left._2 > right._2
        }
      }.take(2)

      val hasOtherCity = map.size > 2

      var count = 0l

      presecond.foreach{
        case (name , cnt)=>{
          var r = cnt * 100 / sum
          list.append(name+" "+r+"%")
          count += r
        }
      }

      if(hasOtherCity){
        list.append("其他"+(100-count)+"%")
      }

      list.mkString(",")

    }

    override def bufferEncoder: Encoder[Buff] = Encoders.product

    override def outputEncoder: Encoder[String] = Encoders.STRING
  }
}
