package com.atguigu.bigdata.sql.sql06

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.util.Try

object Test10 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")

    val ssc = new StreamingContext(conf,Seconds(3))





    ssc.start()
    ssc.awaitTermination()

  }
}
