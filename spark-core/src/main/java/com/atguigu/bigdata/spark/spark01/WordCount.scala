package com.atguigu.bigdata.spark.spark01

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    val wordcount = new SparkConf().setMaster("local").setAppName("wordcount")
    val context = new SparkContext(wordcount)

    val line: RDD[String] = context.textFile("datas")
    val words = line.flatMap(_.split(" "))
    val groups = words.groupBy(x=>x)
    val value = groups.map(a=>(a._1,a._2.size))
    val tuples: Array[(String, Int)] = value.collect()
    tuples foreach println

    context.stop()
  }
}
