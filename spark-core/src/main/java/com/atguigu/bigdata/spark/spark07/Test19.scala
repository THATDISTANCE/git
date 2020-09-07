package com.atguigu.bigdata.spark.spark07

import org.apache.spark.{SparkConf, SparkContext}

object Test19 {
  def main(args: Array[String]): Unit = {

    // TODO Spark 行动算子
    val sparkConf = new SparkConf().setMaster("local").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    // TODO foreach
    val rdd = sc.makeRDD(List(1,2,3,4))
//    rdd.collect()foreach(println)


    println(" outer ==== "+Thread.currentThread().getName)

    rdd.filter{println(""+Thread.currentThread().getName);x=>x % 2==1}collect()foreach{
//      println(" inner ==== "+Thread.currentThread().getName)
//      println
      x=>{
        println(" inner ==== "+Thread.currentThread().getName)
        println(x)
      }
    }
  }
}
