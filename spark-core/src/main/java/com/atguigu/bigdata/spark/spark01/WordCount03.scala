package com.atguigu.bigdata.spark.spark01

import org.apache.spark.{SparkConf, SparkContext}

object WordCount03 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("wordcount3")
    val context = new SparkContext(conf)

    context.textFile("spark-core/datas")
        .flatMap(_.split(" "))
        .groupBy(x=>x)
        .map{x=>(x._1,x._2.size)}
        .collect().foreach(println)

    context.stop()
  }
}
