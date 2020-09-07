package com.atguigu.bigdata.spark.spark07

import org.apache.spark.{SparkConf, SparkContext}

object Test13 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(1,2,3,4))

    val user = new User()

    println(Thread.currentThread().getName)

    rdd.collect()foreach(
      num =>{

        println("inner =======" + Thread.currentThread().getName)
        println(user.page+" ========== "+num)
      }
    )


    sc.stop()
  }

  class User(){
    var page = 20
  }
}
