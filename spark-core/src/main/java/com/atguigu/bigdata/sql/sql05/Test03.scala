package com.atguigu.bigdata.sql.sql05

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Test03 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("application")
    val ssc = new StreamingContext(conf,Seconds(3))

    val socketDs = ssc.socketTextStream("localhost",9999)




    ssc.start()
    ssc.awaitTermination()
  }
}
