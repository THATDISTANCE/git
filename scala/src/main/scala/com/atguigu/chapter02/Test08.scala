package com.atguigu.chapter02

object Test08 {
  def main(args: Array[String]): Unit = {

//    def add(a:Int,b:Int) : Int ={
    ////      a+b
    ////    }
    ////    println(cal(add))
    ////
    ////    def sub(a:Int,b:Int)={
    ////      a-b
    ////    }
    ////
    ////    println(cal(sub))
    //    var add = (a:Int,b:Int)=>{a+b}
    //
    //    var sub = (a:Int,b:Int)=>{a-b}
    //
    //    println(cal(add))
    //    println(cal(sub))
    def cal(fun:(Int,Int)=>Int)={
      fun(1,2)
    }

//    println(cal((a: Int, b: Int) => a + b))
//    println(cal((a: Int, b: Int) => a - b))

//    println(cal((a,b) => a + b))
//    println(cal((a,b)=>a-b))
    println(cal((_-_)))

    println(cal(math.max))

  }
}
