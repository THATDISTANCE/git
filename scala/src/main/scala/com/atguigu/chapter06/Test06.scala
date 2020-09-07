package com.atguigu.chapter06

object Test06 {
  def main(args: Array[String]): Unit = {
    new student1().student1()
    println("====================")
    new student1("alice").student1()
    println("=============")
    new student1("ALICE",9).student1()
  }
}

class student1(){

  var name :String = _
  var age:Int = _

  println("main constructor is invoked")
  println(s"student1[name=$name,age=$age]")

  def this(name:String)={
    this()
    println("the first auxiliary constructor is invoked")
    this.name = name
  }

  def this(name:String,age:Int)={
    this(name)
    println("the second auxiliary constructor is invoked")
    this.age = age
  }

  def student1()={
    println("normal invoking method")
  }

}