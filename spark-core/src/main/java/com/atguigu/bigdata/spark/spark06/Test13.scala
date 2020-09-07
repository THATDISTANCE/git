package com.atguigu.bigdata.spark.spark06

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test13 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(
      List(
        ("hello", 1), ("hello", 2), ("hello", 3)
      )
    )

    val reduRdd : RDD[(String,Int)] = rdd.reduceByKey(_+_)
    reduRdd.collect() foreach println
  }
}
