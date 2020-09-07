package com.atguigu.bigdata.spark.spark08

import org.apache.spark.{SparkConf, SparkContext}

object Test06 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)

    val lineRdd = sc.textFile("spark-core/datas/1.txt")
    val wordRdd = lineRdd.flatMap(_.split(" "))
    val reduRDD = wordRdd.reduce(_+_)
    reduRDD.foreach(println)

    sc.stop()

  }
}
