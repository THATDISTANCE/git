package com.atguigu.bigdata.spark.spark06

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test04 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("test")
    val sc = new SparkContext(conf)

    val rdd = sc.textFile("spark-core/datas/1.txt")

    val sumRdd = rdd.flatMap(_.split(" ")).groupBy(x=>x)

    val value = sumRdd.map {
      case (a, b) => (a, b.size)
    }
    value.collect() foreach println

    sc.stop()
  }
}
