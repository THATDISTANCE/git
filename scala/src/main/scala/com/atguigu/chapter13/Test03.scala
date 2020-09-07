package com.atguigu.chapter13

object Test03 {
  def main(args: Array[String]): Unit = {
//    def f = ()=>{
//      println("f...")
//      10
//    }
//
//    foo(f())
//  }
//
//  def foo(a: Int):Unit = {
//    println(a)
//    println(a)
//  }

    def f = ()=>{
      println("f...")
      10
    }

    foo(f())
  }

  //def foo(a: Int):Unit = {
  def foo(a: =>Int):Unit = {//注意这里变量a没有小括号了
    println(a)
    println(a)
  }

}
