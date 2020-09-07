package com.atguigu.bigdata.spark.spark09

import org.apache.spark.{SparkConf, SparkContext}

object Test02 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("exe")
    val sc = new SparkContext(conf)

    val rdd = sc.makeRDD(List(1,2,3,4),2)

    val sum = sc.longAccumulator("sum")

    val fRdd = rdd.foreach(
      x => {
        sum.add(x)
      }
    )

    println(sum.value)




    sc.stop()
  }
}
