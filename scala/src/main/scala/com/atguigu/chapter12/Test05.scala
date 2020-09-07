package com.atguigu.chapter12

object Test05 {
  def main(args: Array[String]): Unit = {
//    val (first,second) :(String,Int)= ("hello",18)
//    println((first,second))
//
//    val List(first , second , _*) = List(20,"hello",'a',19,18,19)
//
//    println(first+" , "+second)

//    val Array(first,second ,_*) =Array(1,2,3,4)
//    println(first+" , "+ second)

//    val mutable.Map((String,Int)) = Map("a"->1,"b"->2,"c"->3)

   val map : Map[String,Int]= Map("a"->1,"b"->2,"c"->3)

    val v1 : List[(String,Int)] = List(("a",1),("b",2),("c",3))

    for (elem <- v1) {
      println(elem)
    }

    for ((first,second) <- v1) {
      println(first+" , "+second)
    }

    for ((_,a) <- v1) {
      println(a)
    }

    for ((a,_) <- v1) {
      println(a)
    }


    for (("a",b) <- v1) {
      println(b)
    }

  }

}
