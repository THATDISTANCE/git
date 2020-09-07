package com.atguigu.bigdata.spark.spark05

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test07 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("hello")
    val sc = new SparkContext(conf)

    val list:List[Int] = List(1,2,3,4)

    // (1, 2), (3, 4)
    val rdd:RDD[Int] = sc.makeRDD(list, 2)

    val rdd1: RDD[Int] = rdd.map(
      num => {
        println("num >>>>>>" + num)
        num * 2
      }
    )
    val rdd2: RDD[Int] = rdd1.map(
      num => {
        println("num ******" + num)
        num * 2
      }
    )

    rdd2.collect()


    sc.stop()
  }
}
