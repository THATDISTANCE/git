package com.atguigu.bigdata.spark.spark02

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object MemoryRdd {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("1")
    val sc = new SparkContext(conf)

    val rdd: RDD[String] = sc.textFile("spark-core/datas/1.txt",3)

//    val list = List(1,2,3,4,5)
//    val rdd = sc.parallelize(list,3)

    rdd.saveAsTextFile("spark-core/output")

    rdd.collect() foreach println

    sc.stop()
  }
}
