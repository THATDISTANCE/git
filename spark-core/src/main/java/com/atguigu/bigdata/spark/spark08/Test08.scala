package com.atguigu.bigdata.spark.spark08

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test08 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)

    val lineRdd = sc.textFile("spark-core/datas/1.txt")
    val list: RDD[String] = lineRdd.flatMap(_.split(" "))

    val mapRdd = list.map((_,1))

    val str = mapRdd.countByKey()

    println(str)

    val t = mapRdd.countByValue()
    println(t)


    println(list.countByValue())

    sc.stop()

  }
}
