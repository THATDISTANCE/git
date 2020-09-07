package com.atguigu.bigdata.spark.spark01

import org.apache.spark.{SparkConf, SparkContext}

object WordCount05 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("wordcount5")
    val context = new SparkContext(conf)

    println(context.textFile("spark-core/datas")
      .flatMap(_.split(" "))
      .map((_, 1))
      .reduce((a, b) => (a._1, a._2 + b._2)))

    context.stop()
  }
}
