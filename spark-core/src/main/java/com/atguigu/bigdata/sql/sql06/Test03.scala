package com.atguigu.bigdata.sql.sql06

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Test03 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")

    val ssc = new StreamingContext(conf,Seconds(3))

    val rID: ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)

    val intSC = rID.map(
      str => {
        str.toInt
      }
    )

    val value: DStream[Int] = intSC.reduceByWindow((a:Int, b:Int)=>a+b,Seconds(6),Seconds(3))

    value.print()

    ssc.start()
    ssc.awaitTermination()

  }
}
