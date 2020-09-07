package com.atguigu.chapter04

object Test06 {
  def main(args: Array[String]): Unit = {
    var n = 10
//    while(n >= 1){
//      println(n)
//      n-=1
//    }

//    def v2(a: =>Unit): Unit ={
//        println("hello")
//    }
//
//    v2()

//    def v1(condition: =>Boolean):(=>Unit)=>Unit={
//      def do1(op: =>Unit): Unit ={
//        if(condition){
//          op
//          do1(op)
//        }
//      }
//      do1
//    }
//
//    v1(n>=1)({println(n);n-=1})

    def v1(condition: =>Boolean):( =>Unit)=>Unit={
      op => if(condition) {
        op
        v1(condition)(op)
      }
    }

//    def v12(condition: =>Boolean)(op: =>Unit):Unit={
//      if(condition) op ; v12(condition)(op)
//    }
    v1(n>=1)({println(n);n-=1})
  }
}
