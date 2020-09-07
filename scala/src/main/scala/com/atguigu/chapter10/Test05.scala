package com.atguigu.chapter10

import scala.collection.mutable

object Test05 {
  def main(args: Array[String]): Unit = {
//    val v1 = Set(3,41,43,1,4,5,3,55,7,82)
//    println(v1)
//
//    val value = v1 + 10 + 20
//    println(value)
//    println(v1)
//    println(value == v1)
//    val t1 = v1 - 3 - 7
//    println(t1)
//
//    val v2 = Set(1,2)
//
//    val t2 = v1 ++ v2
//    println(t2)
    val v1 = mutable.Set(1,2,3,4,4)
    val v2 = mutable.Set(5,6,7,8)

    v1 += 5 += 4
    println(v1)

    v1 ++= v2
    println(v1)

    v1 -= 1 -= 2 -= 3
    println(v1)

    for (elem <- v1) {
      println(elem)
    }
  }
}


