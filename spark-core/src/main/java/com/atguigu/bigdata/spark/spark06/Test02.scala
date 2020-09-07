package com.atguigu.bigdata.spark.spark06

import scala.util.Random

object Test02 {
  def main(args: Array[String]): Unit = {

    val rand:Random = new Random(20)
    for(i <- 1 to 5){
      println(rand.nextInt(100))
    }

    val rand2:Random = new Random(20)
    for(i <- 1 to 5){
      println(rand2.nextInt(100))
    }
  }
}
