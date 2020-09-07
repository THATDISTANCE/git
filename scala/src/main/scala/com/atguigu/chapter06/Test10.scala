package com.atguigu.chapter06

object Test10 {
  def main(args: Array[String]): Unit = {
//    val person = new Person2()
//    person.printinfo()

//    val student = new Student2()
//    student.printinfo()
//    println(student.name)

    println(new Student2().name)
    println(new Student2().age)
  }
}

class Person2(){

  val name:String = "person"
  var age:Int = 18

  def printinfo()={
    println(s"Person2[name=$name,age=$age]")
  }
}

class Student2() extends Person2{

  override val name = "mike"
  age = 27

  override def printinfo(): Unit = println(s"Student2[name=$name,age=$age]")

  def sayHi(): Unit ={
    println("this is student2's sayhi method")
  }
}