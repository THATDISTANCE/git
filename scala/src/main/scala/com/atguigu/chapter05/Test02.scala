package com.atguigu.chapter05

object Test02 {
  def main(args: Array[String]): Unit = {
    val c = new C(1,2)
    c.v1()

  }
}

class C(a:Int,b:Int){
  def v1(): Unit ={
    println(a)
  }
}
