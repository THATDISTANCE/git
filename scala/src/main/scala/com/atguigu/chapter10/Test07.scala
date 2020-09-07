package com.atguigu.chapter10

object Test07 {
  def main(args: Array[String]): Unit = {

    val tuple01:(String,Int,Char) = ("helo",20,'f')
//    println(tuple01)
//
//    println(tuple01._1)
//    println(tuple01._2)
//    println(tuple01._3)
//
//    println(tuple01.productElement(1))

    for (elem <- tuple01.productIterator) {
      println(elem)
    }

    val v1: Map[String, Int] = Map("a" -> 1 , "b" -> 2 , "c" -> 3)
    val v2: Map[String, Int] = Map("a" -> 1 , "b" -> 2 , ("c",3))

    println(v1 == v2)
    println(v1.eq(v2))

    val v3: (Int, String, (Int, String), (String, String), (Int, Int, Int), List[Int]) = (1,"this",(1,"hello"),("look","world"),(1,2,3),List(1,2,3))
//    println(v3._1+" , "+v3._4._1+" , "+v3._6)
    for (elem <- v3._6) {
      println(elem)
    }

  }
}
