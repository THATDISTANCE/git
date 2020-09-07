package com.atguigu.chapter12

import scala.collection.mutable

object Test01 {
  def main(args: Array[String]): Unit = {

//    val v1 = List(
//      "Hello",
//      "Hello World",
//      "Hello Scala",
//      "Hello Spark in Scala",
//      "Hello Flink in Scala"
//    )
//
//    val flatten = v1.map(_.split(" ")).flatten

//    println(v1.map(_.split(" ")).flatten.groupBy(x=>x).map(x=>(x._1,x._2.length)).toList.sortBy(_._2).reverse.take(3))

//    val map: mutable.Map[String,Int] = mutable.Map()
//    for (elem <- flatten) {
//      if(map contains elem) map(elem) = map(elem) + 1 else map(elem) = 1
//    }
//    for (elem <- map) {
//      println(elem)
//    }

    val t1: List[(String, Int)] = List(
      ("Hello Scala Spark World ", 4),
      ("Hello Scala Spark", 3),
      ("Hello Scala", 2),
      ("Hello", 1)
    )
    println(t1.map(t => (t._1.trim + " ") * t._2)
      .flatMap(_.split(" "))
      .groupBy(x => x)
      .map(x => (x._1, x._2.length))
      .toList
      .sortWith(_._2 > _._2)
      .take(3))

  }
}
