package com.atguigu.chapter10

import scala.collection.mutable

object Test02 {
  def main(args: Array[String]): Unit = {
    val v1 = List(1,2,3,4,5)
//    for(x <- v1){
//      println(x)
//    }

//    v1.foreach(println)
//
////    val ints = v1 :+ 30
//    val ints = 30 +: v1
//    println(ints)
//    println(v1)
//    println(ints == v1)

    val t1 = v1 :+ 30 :+20
    val t2 = 20 +: 18 +: v1

    val t3 = 20 :: 30 :: 40 :: 50 :: v1
    val t4 = 2 :: 3 :: 4 :: 5 :: Nil

    println(t1)
    println(t2)

//    println(t3)
//    println(v1)
//    println(t3 == v1)
//
//    val t5 = t3 :: t4
//    val t6 = t3 ::: t4
//    val t7 = t3 ++ t4
//    println(t6)
//    println(t7)
//
//    val i = v1(3)
//    println(i)
////
//    println(v1)

//    for (elem <- v1) {
//      println(elem)
//    }


  }
}
