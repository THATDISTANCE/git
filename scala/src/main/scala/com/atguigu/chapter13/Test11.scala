package com.atguigu.chapter13

object Test11 {
  def main(args: Array[String]): Unit = {
    val tupleList: List[(String, Int)] = List(
      ("Hello Scala Spark World ", 4),
      ("Hello Scala Spark", 3),
      ("Hello Scala", 2),
      ("Hello", 1)
    )

    println(tupleList.map(a => a._1.trim + " " * a._2)
      .flatMap(_.split(" "))
      .groupBy(x => x)
      .map(a => (a._1, a._2.length))
      .toList.sorted
        .take(3)
      )

    (1 to 100).map{
      case _ => println("he")
    }


  }

}
