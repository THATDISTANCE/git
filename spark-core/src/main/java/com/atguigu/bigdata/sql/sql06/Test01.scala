package com.atguigu.bigdata.sql.sql06

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Test01 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")
    val ssc = new StreamingContext(conf,Seconds(3))

    ssc.checkpoint("spark-core/output")

    def updateFun(newValues:Seq[Int],runningCount:Option[Int])={
      var count = 0
      for (elem <- newValues) {
        count += elem
      }
      val tmp = runningCount.getOrElse(0) + count
      Option(tmp)
    }

    val lineSC = ssc.socketTextStream("localhost",9999)

    val mapSC = lineSC.map((_,1))

    val value = mapSC.updateStateByKey[Int](updateFun _)

    value.print()

    ssc.start()
    ssc.awaitTermination()
  }

  case class User(
                 name : String ,
                 age : Long
                 )
}
