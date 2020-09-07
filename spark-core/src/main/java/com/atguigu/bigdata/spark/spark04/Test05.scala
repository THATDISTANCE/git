package com.atguigu.bigdata.spark.spark04

import org.apache.spark.{SparkConf, SparkContext}

object Test05 {
  def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setMaster("local[*]").setAppName("he")
      val sc = new SparkContext(conf)

      val rdd = sc.parallelize(List("hello scala", "hello spark"), 3)
      rdd.flatMap(transform).collect() foreach println

      def transform(s: String) = {
        s.split(" ")
      }

      sc.stop()
    }
}