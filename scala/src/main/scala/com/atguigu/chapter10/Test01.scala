package com.atguigu.chapter10

import scala.collection.mutable.ArrayBuffer

object Test01 {
  def main(args: Array[String]): Unit = {

    var v1 = new Array[Int](3)
    v1(0) = 10
    v1(1) = 20
    v1(2) = 30

//    println(v1.mkString(","))

    val v2 = Array(1,2,3,4,5)

    val t8 = v2 :+ 20 :+ 40
    for (elem <- t8) {
      print(elem)
    }
//    println(v2.mkString(","))
//
//    println(v1.apply(2))
//
//    v1(2) = 50
//    println(v1(2))
//
//    v1.update(2,100)
//
//    println(v1(2))


    println("======================")

//    for(x <- 0 until v2.length){
//      print(x)
//    }

//    for(x <- v2.indices ){
//      println(v2(x))
//    }

//    v2.foreach(println)

//    for (elem <- v2) {
//      println(elem)
//    }

//    for(elem <- v2.iterator){
//      println(elem)
//    }

//    val t1 = v1 :+ 20
//    println(t1)
//    println(v1)
//    println(t1 == v1)

//    val ints = v2 :+ 100
//    println(ints)
//    println(v2)
//    println(ints == v2)

    var v3 = ArrayBuffer(1,2,3,4,5)
////    v3 :+ 40
////    50 +: v3
//
//    val ints = v3 += 30
//
//    19 +=: v3
//    v3 -= 30
//
//    println(v3 == ints)
    
//    val v4 = v3 ++= v1
//
//    val v5 = v1 ++=: v3
//
//    val v6 =
//
//    println(v4)
//    println(v5)
//
//    println(v3 == v4)


    var v7 = ArrayBuffer(11,22,33)
    var v8 = ArrayBuffer(44,55)

    v7 ++= v8
    v8 ++= v7

    println(v7)
    println(v8)


    var ints = new ArrayBuffer[Int]()

    val ints1 = ints += 3
    val ints2 = ints :+ 3
    val r1 = 3 +=: 4 +=: ints

    println(ints == ints1)

    println(ints == ints2)

    ints :+= 30


    println("===========r1=========")
    println(r1)



//    println(unit)
//
//    var t = ArrayBuffer(1,2,3,4,5)
//
//    t :+= 30
//
//    30 +=: t
//
//    val t2 = t :+ 30 :+ 30 :+ 30
//    val t3 = 20 +: t
//
//    println(t)
//    println("=============")
//    println(t2)
//    println(t3)



  }
}
