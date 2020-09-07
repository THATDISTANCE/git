package com.atguigu.bigdata.spark.spark06

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test07 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("test")
    val sc = new SparkContext(conf)

    val rdd = sc.makeRDD(List(1,2,3,4,5,6))

//    val textRdd = sc.textFile("spark-core/datas/apache.log")

//    val samRdd = rdd.sample(false,0.5)
    val samRdd = rdd.sample(true,2)
    samRdd.collect() foreach println

    sc.stop()
  }
}