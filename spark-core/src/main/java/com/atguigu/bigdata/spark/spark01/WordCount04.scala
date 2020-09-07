package com.atguigu.bigdata.spark.spark01

import org.apache.spark.{SparkConf, SparkContext}

object WordCount04 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("wordcount4")
    val context = new SparkContext(conf)

    context.textFile("spark-core/datas")
        .flatMap(_.split(" "))
        .map((_,1))
        .reduceByKey(_+_)
        .collect() foreach println

    context.stop()
  }
}
