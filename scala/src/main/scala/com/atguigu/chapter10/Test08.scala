package com.atguigu.chapter10

object Test08 {
  def main(args: Array[String]): Unit = {
    val v1 = List(1,2,3)
    val v2 = Set(4,5,6,3)

//    println(v1.length)
//    println(v1.size)
//
//    println(v2.size)

//    for (elem <- v2) {
//      println(elem)
//    }

//    for (elem <- v2.iterator) {
//      println(elem)
//    }

    println(v2.mkString(","))
    println(v2.contains(5))
  }
}
