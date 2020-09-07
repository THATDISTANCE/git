package com.atguigu.bigdata.sql.sql05

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Test09 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")

    val ssc = new StreamingContext(conf,Seconds(1))

    val lineDS = ssc.socketTextStream("localhost",9999)

    val wordDS = lineDS.flatMap(_.split(" "))

    val mapDS = wordDS.map((_,1))

    mapDS.reduceByKeyAndWindow((x:Int,y:Int)=>x+y,Seconds(3),Seconds(1)).print()

    ssc.start()
    ssc.awaitTermination()

  }

}
