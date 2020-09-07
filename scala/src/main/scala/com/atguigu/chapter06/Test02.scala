//package com.atguigu.chapter06
//
//object Test02 {
//  def main(args: Array[String]): Unit = {
//    println("this is a "+commonValue)
//    commonMethod()
//  }
//}

package ccc{
  package ddd{

    import java.io.Console

    import com.atguigu.chapter06._

    object Test02 {
      def main(args: Array[String]): Unit = {
        println(Inner.in)
        commonMethod()
      }
    }
  }
}