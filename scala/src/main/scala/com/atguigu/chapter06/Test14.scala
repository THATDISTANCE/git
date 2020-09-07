package com.atguigu.chapter06

object Test14 {
  def main(args: Array[String]): Unit = {

//    val cat = new Cat11
//    println(cat.name)
//    cat.miaomiao()
//    cat.eat()
//    println(cat.age)
//    cat.play()
    val women10 = new Women100
    println(women10.age)
    women10.play()
  }
}

class Animal22 {

  var name:String = "animal"

  def eat() ={
    println("Animal eating")
  }

}

class Cat11 extends Animal22 with young{

//  name = "lucy"

  def miaomiao()={
    println("cat miaomiaojiao")
  }

//  override def eat(): Unit ={
//    println("cat eationg")
//  }

}

trait young {

  var age:Int = 10

  def play()={
    println("young is playing")
  }

}

class Women100 extends young{

}