package com.atguigu.bigdata.spark.spark07

import org.apache.spark.{SparkConf, SparkContext}

object Test02 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("hello")
    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(List(1,2,3,4,5),2)

    val user = new User

    rdd.foreach(
      x=>{
        println(user.num+" , "+(x+1))
      }
    )

    sc.stop()

  }

  class User(){
    val num = 10
  }

}
