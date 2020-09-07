package com.atguigu.bigdata.spark.spark07

import org.apache.spark.{SparkConf, SparkContext}

object Test17 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)


//    val rdd = sc.makeRDD(List(
//        "hello", "scala", "hello", "spark"
//    ))
//
//    println(rdd.countByValue())


    val rdd = sc.makeRDD(List("hello", "hello", "hello", 1))
    println(rdd.countByValue())


    sc.stop()

  }
}
