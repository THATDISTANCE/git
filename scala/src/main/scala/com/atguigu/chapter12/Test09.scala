package com.atguigu.chapter12

object Test09 {
  def main(args: Array[String]): Unit = {

//    implicit def v1(num:Int):MyRichInt={
//      new MyRichInt(num)
//    }
//
//    println(12.myMax(4))
//
//    implicit val name = "hello"
//    implicit val age = 18
//
//    def v2(implicit tmp:String)={
//      println(tmp)
//    }
//
//    v2("name",18)
  }
}


class MyRichInt(val self: Int) {
  def myMax(i: Int): Int = {
    if (self < i) i else self
  }
  def myMin(i: Int): Int = {
    if (self > i) i else self
  }
}