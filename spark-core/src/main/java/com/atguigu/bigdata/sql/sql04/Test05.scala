package com.atguigu.bigdata.sql.sql04

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.{Duration, StreamingContext}

object Test05 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[2]").setAppName("app")
    val ssc = new StreamingContext(conf,Duration(3000))

    val lineStream : ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)
    val wordStream = lineStream.flatMap(
      x => {
        x.split(" ")
      }
    )
    val tupStream = wordStream.map((_,1))
    val resultStream = tupStream.reduceByKey(_+_)

    resultStream.print()

    ssc.start()
    ssc.awaitTermination()

  }
}
