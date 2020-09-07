package com.atguigu.bigdata.spark.spark06

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test14 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(
      List(
        ("hello", 1), ("hello", 2), ("hello", 3)
      )
    )

    val groRdd : RDD[(String,Iterable[Int])] = rdd.groupByKey()
    val mRdd = groRdd.map {
      case (a, b) => (a, b.sum)
    }
    mRdd.collect() foreach println
  }
}
