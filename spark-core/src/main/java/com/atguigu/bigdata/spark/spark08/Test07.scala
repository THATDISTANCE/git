package com.atguigu.bigdata.spark.spark08

import org.apache.spark.{SparkConf, SparkContext}

object Test07 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)

    val lineRdd = sc.textFile("spark-core/datas/1.txt")
    val wordRdd = lineRdd.flatMap(_.split(" "))
    val mapRDD = wordRdd.map(x=>x)
    val reduRdd = mapRDD.reduce(_+_)
    reduRdd.foreach(println)

    sc.stop()

  }
}
