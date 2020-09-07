package com.atguigu.chapter01

import scala.io.StdIn

object Test07 {
  def main(args: Array[String]): Unit = {
    val age = StdIn.readInt()

    val unit: Any = if( age < 18 ){
      "青年"
      "少年"
      123
    }else{
      "hello"
      "world"

    }
    println(unit)
  }
}
