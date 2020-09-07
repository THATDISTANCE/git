package com.atguigu.bigdata.spark.spark05

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test09 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("hello")
    val sc = new SparkContext(conf)

    val rdd = sc.makeRDD(List(1,2,3,4),2)
    val listRdd : RDD[Int] = rdd.mapPartitions(
      part=>{
        println("****************")
        part.map(_*2)
      }
    )

//    listRdd.collect()
    listRdd.saveAsTextFile("spark-core/aout")
    sc.stop()
  }
}
