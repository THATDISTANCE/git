package com.atguigu.bigdata.spark.spark01

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount02 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("wordcount2")
    val context = new SparkContext(conf)

    context.textFile("datas")
    .flatMap(_.split(" "))
      .groupBy(x=>x)
      .map{
        case (a,b)=>(a,b.size)
      }
      .collect() foreach println

    context.stop()
  }
}
