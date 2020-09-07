package com.atguigu.chapter11

object Test04 {
  def main(args: Array[String]): Unit = {
    val v1 = new Student02("hello",18)
    v1 match {
      case student01: Student02 => println("yes")
      case _ => println("no")
    }
  }
}

case class Student02(name:String,age:Int)
