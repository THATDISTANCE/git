package com.atguigu.bigdata.spark.spark06

import org.apache.spark.{SparkConf, SparkContext}

object Test11 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    val rdd1 = sc.makeRDD(List(1,2,3,4))
    val rdd2 = sc.makeRDD(List(3,4,5,6))
    val rdd22 = sc.makeRDD(List("a","b", "c"))

    rdd1.intersection(rdd2) foreach print
    println("8888888888888888")
    rdd1.union(rdd2) foreach print
    println("8888888888888888888")
    rdd1.subtract(rdd2) foreach println

  }
}
