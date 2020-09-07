package com.atguigu.bigdata.sql.sql07

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Test01 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")
    val spark = new StreamingContext(conf,Seconds(3))




    spark.start()
    spark.awaitTermination()
  }
}
