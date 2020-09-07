package com.atguigu.chapter08

object Test04 {
  def main(args: Array[String]): Unit = {

    val stu1 = new Student02
    val per1 = new Person02

    println(stu1.isInstanceOf[Student02])
    println(stu1.isInstanceOf[Person02])

    println(per1.isInstanceOf[Student02])
    println(per1.isInstanceOf[Person02])

    val person0 = stu1.asInstanceOf[Person02]
    println(person0)

    println(person0 == stu1)
    println(person0 == per1)
//
//    val student0 = per1.asInstanceOf[Student02]
//    println(student0)

    val v1: Class[Person02] = classOf[Person02]
    println(v1)

  }
}

class Student02 extends Person02 {}

class Person02{}

object enum extends Enumeration{
  var monday = Value(1)
  var tuesday = Value(2)
}

object app extends App{
  println("this is app")
  type day = Int

  def v1():day={
    23
  }

  println(v1())

}