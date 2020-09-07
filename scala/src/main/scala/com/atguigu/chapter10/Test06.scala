package com.atguigu.chapter10

import scala.collection.mutable

object Test06 {
  def main(args: Array[String]): Unit = {
    val v1: Map[String, Int] = Map("a" -> 1,"b" -> 2, "c" -> 3)
    println(v1)
//    v1.foreach((kv:(String,Int))=>println(kv))
//    v1.foreach(println)
//    for (elem <- v1) {
//      println(elem)
//    }
//
//    for (elem <- v1.keys) {
//      println(elem)
//    }
//
//    for (elem <- v1.values) {
//      println(elem)
//    }

//    println(v1.get("a").get)
//    println(v1("a"))
//
//    val t1 = v1.get("d")
//    println(t1)
//    println(v1.getOrElse("d", "hello"))
    val v2 = mutable.Map("a" -> 1, "b" -> 2, "c" -> 3)
    val t1 = v2 + ("d" -> 4)
    println(t1)
    v2 += ("d" -> 4) += ("e" -> 5)
    println(v2)
    v2 -= "a" -= "b"
    println(v2)

    v2.update("d",100)
    v2("e") = 2000

    println(v2)

//    val r1 = v1 ++ v2
//    println(r1)

    val r2 = v2 ++= v1
    println(r2)
    println(v2)
    println(r2 == v2)
  }
}
