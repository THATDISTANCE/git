package com.atguigu.bigdata.sql.sql05

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Minutes, Seconds, StreamingContext}

object Test05 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")
    val ssc = new StreamingContext(conf,Seconds(3))

    val lineSc = ssc.socketTextStream("localhost",9999)
    val lineSc2 = ssc.socketTextStream("localhost",8888)

    val stream1 = lineSc.map(x=>(x,1))
    val stream2 = lineSc2.map(x=>(x,1))

    val ss1 = stream1.window(Seconds(30))
    val ss2 = stream2.window(Minutes(1))

    val value = ss1.join(ss2)

    value.print()

    ssc.start()
    ssc.awaitTermination()
  }
}
