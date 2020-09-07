package com.atguigu.chapter11

object Test03 {
  def main(args: Array[String]): Unit = {
    val hello = new Student("hello",218)
    hello match {
      case Student("hello",18) => println("yes")
      case _ => println("no")
    }
  }
}


class Student(var name:String,var age:Int){}

object Student{
  def apply(name: String, age: Int): Student = new Student(name, age)

  def unapply(arg: Student): Option[(String, Int)] = {
    if (arg == null) None else Some(arg.name,arg.age)
  }
}