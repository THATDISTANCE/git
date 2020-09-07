package com.atguigu.bigdata.exe

import org.apache.spark.{SparkConf, SparkContext}

object Test01 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("exe")

    val sc = new SparkContext(conf)

    val wordRdd = sc.parallelize(List(1,2,3,4,5,1,2,3))

    val tupRdd = wordRdd.map((_,1))

    val redRdd = tupRdd.reduceByKey(_+_)

    redRdd.collect() foreach(println)

  }
}
