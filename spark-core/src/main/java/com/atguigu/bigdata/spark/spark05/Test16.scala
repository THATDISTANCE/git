package com.atguigu.bigdata.spark.spark05

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test16 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)
    rdd.saveAsTextFile("spark-core/output")

    val value = rdd.groupBy(x=>x % 2)
    value.saveAsTextFile("spark-core/out")

    sc.stop()
  }
}
