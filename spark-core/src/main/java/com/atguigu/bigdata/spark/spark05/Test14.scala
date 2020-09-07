package com.atguigu.bigdata.spark.spark05

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Test14 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)

    val gRdd = rdd.glom()

    gRdd.collect().foreach(
      x=>{
        println("hello")
        println(x.max)
      }

    )

    sc.stop()
  }
}
