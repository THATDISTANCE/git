package com.atguigu.bigdata.spark.spark09

import org.apache.spark.broadcast.Broadcast
import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}

object Test04 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("exe")
    val sc = new SparkContext(conf)


    val list = List("a","b","c","d")

    val value: Broadcast[List[String]] = sc.broadcast(list)


    val rdd = sc.makeRDD(List(("a",1),("c",2)))

    val filRdd = rdd.filter {
      case (a, b) => {
        value.value.contains(a)
      }
    }
    filRdd.collect()foreach(println)

    sc.stop()
  }
}
