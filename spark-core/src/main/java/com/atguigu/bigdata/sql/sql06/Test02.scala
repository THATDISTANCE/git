package com.atguigu.bigdata.sql.sql06

import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Test02 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")

    val ssc = new StreamingContext(conf,Seconds(3))

    val lineRDD: RDD[String] = ssc.sparkContext.parallelize(List("a","b","c"))
    val new1: RDD[(String, Int)] = lineRDD.map((_,1))

    val lineSC: ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)

    val new2: DStream[(String, Int)] = lineSC.map((_,1))

    new2.transform{
      rdd =>{
        rdd.join(new1)
      }
    }



  }
}
