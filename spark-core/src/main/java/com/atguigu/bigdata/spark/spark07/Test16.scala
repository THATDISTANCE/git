package com.atguigu.bigdata.spark.spark07

import org.apache.spark.{SparkConf, SparkContext}

object Test16 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(1,2,3,4),2)

    println(rdd.aggregate(0)(_ + _, _ + _))

    println(rdd.aggregate(10)(_ + _, _ + _))

    println(rdd.fold(0)(_ + _))

    println(rdd.fold(10)(_ + _))

    sc.stop()

  }
}
