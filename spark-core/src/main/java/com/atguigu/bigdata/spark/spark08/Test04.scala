package com.atguigu.bigdata.spark.spark08

import org.apache.spark.{SparkConf, SparkContext}

object Test04 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)

    val lineRdd = sc.textFile("spark-core/datas/1.txt")
    val wordRdd = lineRdd.flatMap(_.split(" "))
    val mapRdd = wordRdd.map((_,1))
    val redRdd = mapRdd.combineByKey(
      x=>x,
      (x:Int,y:Int)=>x+y,
      (x:Int,y:Int)=>x+y
    )

    redRdd.collect()foreach(println)

    sc.stop()

  }
}
