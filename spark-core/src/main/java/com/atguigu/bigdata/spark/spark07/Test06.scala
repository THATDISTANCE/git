package com.atguigu.bigdata.spark.spark07

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Test06 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    val lineRDD : RDD[String] = sc.textFile("spark-core/datas/1.txt")

    val wordRdd : RDD[String]= lineRDD.flatMap(_.split(" "))

    val mapRdd : RDD[(String,Int)] = wordRdd.map((_,1))

    mapRdd.combineByKey(
      x=>x,
      (x:Int,y:Int)=>x+y,
      (X:Int,y:Int)=>X+y
    ).collect() foreach(println)
  }
}
