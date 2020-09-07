package com.atguigu.chapter04

object Test07 {


  def main(args: Array[String]): Unit = {
    lazy val i = sum(1,2)
    println("hello")
    println(i)
  }


  def sum(i: Int, i1: Int):Int = {
    println("sum/...")
    i+i1
  }


}
