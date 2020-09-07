package com.atguigu.chapter13

object Test12 {
  def main(args: Array[String]): Unit = {

    val list = List(2, 1)
    list match {
      case first :: hell :: look => println("第二个元素是1")
      case first :: second :: rest => println("至少有两个元素： " + first + second + rest)
      case _ => println("其它情况")
    }


  }
}
