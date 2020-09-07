package com.atguigu.chapter10

import scala.collection.mutable.ArrayBuffer

object Test03 {
  def main(args: Array[String]): Unit = {

    var v1 = ArrayBuffer(1, 2, 3)
    v1 :+= 3
    println(v1)
//    println(v2)
////    println(v1 == v2)
//
//    val v2 = ArrayBuffer(4,5,6)
//    v2 :+ 3

  }
}
