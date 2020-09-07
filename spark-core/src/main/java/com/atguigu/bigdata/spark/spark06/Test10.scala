package com.atguigu.bigdata.spark.spark06

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test10 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    val rdd : RDD[String] = sc.makeRDD(
      List("1", "2","11", "22", "3")
    )

    val ascRdd = rdd.sortBy(x=>x.toInt,true)
    ascRdd.collect() foreach println


    sc.stop()
  }
}
