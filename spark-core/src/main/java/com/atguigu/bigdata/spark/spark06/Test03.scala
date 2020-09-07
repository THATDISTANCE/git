package com.atguigu.bigdata.spark.spark06

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test03 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("test")
    val sc = new SparkContext(conf)

    val list:List[Int] = List(1,2,3,4)

    val rdd:RDD[Int] = sc.parallelize(list,2)

    val pRdd : RDD[Int] = rdd.mapPartitions(
      t=>{
        println("*******")
        t.map(_*2)
      }
    )
    pRdd.collect()

    sc.stop()
  }
}
