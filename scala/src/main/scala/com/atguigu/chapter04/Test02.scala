package com.atguigu.chapter04

object Test02 {
  def main(args: Array[String]): Unit = {
//    def recur(n:Int):Int={
//      if(n <= 0) 1
//      else n * recur(n-1)
//    }
//    println(recur(6))


//    def recur(t:Int,n:Int):Int={
//      if(n <= 0) 1
//      else recur(t*n,n-1)
//    }

    def recer(t:Int,n:Int):Int={
      if(n<=0) 1
      else recer(t*n,n-1)
    }
  }
}
