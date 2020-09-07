package com.atguigu.bigdata.spark.spark04

import org.apache.spark.{SparkConf, SparkContext}

object Testw04 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("he")
    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(List(1,2,3,4,5,6),3)
    val value = rdd.mapPartitionsWithIndex(
      (index, datas) => {
        datas.map(
          x=>(index,x)
        )
      }
    )
    value foreach println

    sc.stop()
  }
}
