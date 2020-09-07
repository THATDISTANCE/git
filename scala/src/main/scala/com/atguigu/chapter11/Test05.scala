package com.atguigu.chapter11

object Test05 {
  def main(args: Array[String]): Unit = {
    val v1 = List(("a",1),("b",2),("c",3))
    val v2 = v1.map(x=>(x._1,x._2 *2))
    println(v1)
    println(v2)
    println("============")

    println(v1.map {
      case (a, b) => (a, b * 2)
    })


  }
}
