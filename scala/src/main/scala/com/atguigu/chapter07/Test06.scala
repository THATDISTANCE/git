package com.atguigu.chapter07

object Test06 {
  def main(args: Array[String]): Unit = {
    val v1: Array[Array[Array[Array[Array[Int]]]]] = Array.ofDim[Int](1,2,3,4,5)
    v1(0)(0)(2)(3)(4) = 500
    v1(0)(1)(2)(3)(4) = 200
    v1(0)(0)(0)(0)(0) = 100

    v1 foreach(_.foreach(_.foreach(_.foreach(_.foreach(println)))))



    var v2 = List(1,2,3)
    var v3 = List(5,6,7)

    var v5 = v2 :: v3

    println(v5)

    var v6 = v2 ++ v3
    println(v6)
    var v7 = v2 ::: v3
    println(v7)

//    var v4 = 12 :: v2
//    var v3 = 12 :: 34 :: 56 :: Nil

  }
}
