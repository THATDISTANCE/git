package com.atguigu.chapter01

object Test15 {
  def main(args: Array[String]): Unit = {

    val ints = new Array[Int](5)
    ints(0) = 13
    ints(1) = 6
    ints(2) = 24
    ints(3) = 15
    ints(4) = 35
    for (elem <- ints) {
      println(elem)
    }
  }
}
