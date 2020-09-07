package com.atguigu.bigdata.sql.sql05

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Test10 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")
    val ssc = new StreamingContext(conf,Seconds(3))

    ssc.checkpoint("spark-core/checkpoint1")

    val lineDS:DStream[String] = ssc.socketTextStream("localhost",9999)

    val wordDS: DStream[String] = lineDS.flatMap(_.split(" "))

    wordDS.countByValueAndWindow(Seconds(6),Seconds(3)).print()


    ssc.start()
    ssc.awaitTermination()
  }
}
