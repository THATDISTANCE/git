package com.atguigu.bigdata.spark.spark04

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test01 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("hello")
    val sc = new SparkContext(conf)

    val rdd: RDD[String] = sc.textFile("spark-core/datas/apache.log")
    val value = rdd.map(
      log => {
        log.split(" ")(6)
      }
    )
    value.saveAsTextFile("spark-core/datas/output")

    sc.stop()
  }
}
