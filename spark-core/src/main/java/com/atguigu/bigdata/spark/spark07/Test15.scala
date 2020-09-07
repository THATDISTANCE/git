package com.atguigu.bigdata.spark.spark07

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Test15 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    val rdd : RDD[Int] = sc.makeRDD(List(1,4,3,2))

//    rdd.collect()foreach println
//    println("************")
//    println(rdd.reduce(_ + _))
//
//    println(rdd.count())
//    println(rdd.first())
//    rdd.take(3) foreach println
//    rdd.take(3).reverse foreach println
//    rdd.takeOrdered(3) foreach println


  }
}
