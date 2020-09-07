package com.atguigu.chapter07

object Test01 {
  def main(args: Array[String]): Unit = {
    val tt = new TT
    println(tt.monday)
  }
}


//object T extends App{
//  println("you are a loser ")
//
//  type m = String
//  def v(a:m) = {
//    println("helllo")
//  }
//
//  var i : m = _
//
//  v(i)
//}

class TT extends Enumeration{
  var monday = Value(2)
  var tuesday = Value(1)
}
