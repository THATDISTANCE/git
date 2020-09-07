package com.atguigu.chapter08

object Test02 extends A {
  def main(args: Array[String]): Unit = {
    v2()
  }
}

trait B{
  var i = 10
  def v1()={
    println("hello world !!")
  }
}
class A{
  B=>
  var i = 10
  def v2()={
    println("B:"); println(this.i+" , "+B.i)
  }

}