package com.atguigu.chapter02

import scala.io.StdIn

object Test01 {
  def main(args: Array[String]): Unit = {
    val age = StdIn.readInt()
    val v1: Any = if (age < 18) {
      if(age < 15){
        "太小了"
      }
    } else {
      "what is your name"
    }
    println(v1)
  }
}
