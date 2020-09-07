package com.atguigu.chapter13

object Test04 {
  def main(args: Array[String]): Unit = {

//    def f = () => {println("hello") ; 10}
//
//
//    def foo(a:Int)={
//      println(a)
//      println(a)
//    }
//
//    foo(f())

    def f = ()=>{println("hello");3}
    def foo(a: =>Int)={println("world")}

    foo(f())


  }
}
