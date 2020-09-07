package com.atguigu.chapter13

object Test08 {
  def main(args: Array[String]): Unit = {
    println(new B().i)
    println(new B().v)
    println(new B().j)
  }
}

abstract class A{
  var i:Int
  val j = 30
  def v():Int
  def v2()={println("hello world")}
}
class B extends A{
  override val j = 3
  def v:Int ={
    println("hello")
    3
  }

  override var i: Int = _
}
