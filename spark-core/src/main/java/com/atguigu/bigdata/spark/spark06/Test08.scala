package com.atguigu.bigdata.spark.spark06

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

import scala.collection.mutable

object Test08 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("test")
    val sc = new SparkContext(conf)

    val rdd: RDD[Int] = sc.makeRDD(List(1,2,1,2,1,2),3)
//    val value = rdd.map(x=>(x,null)).reduceByKey((x,_)=>x).map(_._1)
    val disRdd = rdd.distinct()
    disRdd.collect() foreach println


    sc.stop()

  }
}
