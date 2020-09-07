package com.atguigu.bigdata.sql.sql02

import org.apache.spark.SparkConf

object Test02 {
  def main(args: Array[String]): Unit = {

    val hello = new Hello("zhangsan",16)

    val hello2 = new Hello("lisi",14)

    hello match {
      case hello2 =>{
        println("000000")
      }
      case _ => println("error")
    }

  }

  class Hello(val name:String,val age:Int)
}
