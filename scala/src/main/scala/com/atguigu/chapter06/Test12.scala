package com.atguigu.chapter06

object Test12 {
  def main(args: Array[String]): Unit = {
    val animal = new Animal {

      override var name: String = "alice"

      override def eat(): Unit = println(s"$name is eating")

    }
    println(animal.name)
    animal.eat()
  }
}

abstract class Animal {
  var name : String
  def eat(): Unit ={}
}
