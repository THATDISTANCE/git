package com.atguigu.bigdata.sql.sql06

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Test04 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")

    val ssc = new StreamingContext(conf,Seconds(3))

    ssc

    val rID: ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)

    rID.window(Seconds(6))




    ssc.start()
    ssc.awaitTermination()

  }
}
