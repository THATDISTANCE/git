package com.atguigu.chapter10

object Test12 {
  def main(args: Array[String]): Unit = {

    val v1 = List(1,2,3,4)
    println(v1.reduce(_ + _))
    println(v1.reduce(_ - _))

    println(v1.reduceLeft(_ - _))
    println(v1.reduceRight(_ - _))

    println(v1.fold(10)(_ + _))

    println(v1.foldRight(10)(_ - _))


  }
}
