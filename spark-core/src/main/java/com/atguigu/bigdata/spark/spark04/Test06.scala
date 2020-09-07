package com.atguigu.bigdata.spark.spark04

import org.apache.spark.{SparkConf, SparkContext}

object Test06 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("he")
    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(List(List(1,2,3),List(5,6),4))
    rdd.flatMap(
      datas=>datas match {
        case list:List[Int] => list
        case d => List(d)
      }
    ).collect() foreach println


    sc.stop()
  }
}
