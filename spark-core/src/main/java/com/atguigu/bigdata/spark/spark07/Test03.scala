package com.atguigu.bigdata.spark.spark07

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test03 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("exe")
    val sc = new SparkContext(conf)

    val lineRdd : RDD[String] = sc.textFile("spark-core/datas/1.txt")
    val wordRdd : RDD[String]= lineRdd.flatMap(_.split(" "))
    val mapRdd = wordRdd.map(x=>(x,1))
    val aggRdd = mapRdd.aggregateByKey(0)(_+_,_+_)
    aggRdd.foreach(println)

    sc.stop()
  }
}
