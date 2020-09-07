package com.atguigu.chapter01

import scala.collection.immutable

object Test12 {
  def main(args: Array[String]): Unit = {
    val v1: immutable.IndexedSeq[Int] = for(i <- 1 to 10) yield i*i
    println(v1)

    for(x <- Array(12,23,45,56,3.0) reverse) println(x)

    for(x <-Array(1,2,3,4,5)) println(x)
  }
}
