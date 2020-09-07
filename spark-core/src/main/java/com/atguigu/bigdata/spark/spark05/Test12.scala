package com.atguigu.bigdata.spark.spark05

import org.apache.spark.{SparkConf, SparkContext}

object Test12 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    val list:List[String] = List(
      "hello scala", "hello spark"
    )

    val rdd = sc.makeRDD(list,1)
    val fRdd = rdd.flatMap(_.split(" "))
    fRdd foreach println

    sc.stop()
  }
}
