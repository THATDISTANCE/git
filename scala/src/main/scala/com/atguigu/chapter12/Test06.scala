package com.atguigu.chapter12

object Test06 {
  def main(args: Array[String]): Unit = {

    val x = new Student("hello",18)
//    val y = new Student("hello",119)
    val res = x match {
//      case s if s.eq(y) => "yes"
      case Student("hello",10) => "hello 18"
      case _ => "no hello"
    }
    println(res)
  }
}

case class Student(var name:String,var age:Int){}
