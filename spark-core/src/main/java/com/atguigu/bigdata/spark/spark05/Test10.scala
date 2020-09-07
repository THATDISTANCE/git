package com.atguigu.bigdata.spark.spark05

import org.apache.spark.{SparkConf, SparkContext}

object Test10 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.parallelize(List(1,2,3,4),2)

    val listRdd = rdd.mapPartitions(
      x=>List(x.max).iterator
    )

    listRdd.saveAsTextFile("spark-core/output")

    sc.stop()

  }
}
