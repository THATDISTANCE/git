package com.atguigu.bigdata.spark.spark04

import org.apache.spark.{SparkConf, SparkContext}

object Test02 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("hello")
    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(List(1,2,3,4),2)
    val value = rdd.mapPartitions(
      log => log.filter(_ % 2 == 0)
    )
    value.saveAsTextFile("spark-core/output")

    sc.stop()
  }
}
