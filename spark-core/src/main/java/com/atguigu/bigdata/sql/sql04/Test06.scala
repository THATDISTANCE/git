package com.atguigu.bigdata.sql.sql04

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Test06 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("RDDStream")

    val ssc = new StreamingContext(conf, Seconds(4))

    val ds = ssc.textFileStream("spark-core/in")
    ds.print()


    ssc.start()

    ssc.awaitTermination()



  }
}
