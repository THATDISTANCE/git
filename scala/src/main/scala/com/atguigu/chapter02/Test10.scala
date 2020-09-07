package com.atguigu.chapter02

object Test10 {
  def main(args: Array[String]): Unit = {
//    def v1(a:Int)={
//      1
//    }
//
//    var i = v1 _
//    println(i)

//    def v1(a:Int,b:Int,op:(Int,Int)=>Int)={
//      op(a,b)
//    }
//
//    println(v1(1, 2, (a, b) => a + b))
//    println(v1(1, 2, (a, b) => a - b))
//=====================================================
//    def v1(): ()=>Unit ={
//      def v2(): Unit ={
//        println("hello......")
//      }
//      v2
//    }

//    val v3 = v1()
//    v3()

//    v1()()
//======================================================

    def v1(a:Int) : Int=>Unit={
      def v2(b:Int): Unit ={
        println("HELLO")
      }
      v2
    }

    v1(1)(2)






  }
}
