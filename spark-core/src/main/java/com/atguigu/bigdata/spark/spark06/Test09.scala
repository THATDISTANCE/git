package com.atguigu.bigdata.spark.spark06

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test09 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("test")
    val sc = new SparkContext(conf)

    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4,5,6),3)
    val filRdd = rdd.filter(x=>true)
    val coalRdd = filRdd.coalesce(4,true)
    coalRdd.saveAsTextFile("spark-core/output")

    sc.stop()

  }
}
