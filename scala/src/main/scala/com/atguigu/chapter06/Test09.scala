package com.atguigu.chapter06

object Test08 {
  def main(args: Array[String]): Unit = {
//    new Student("hello",18)
//    new Student("hello",18,"123")
//    new Person("ff",31414)
//    new Person("ffff",12314124,"41241")

//    new Person("name",121).printInfo()
    new Student("name",1341).printInfo()
  }
}

class Person(var name:String,var age:Int){

  var idNo:String = _
  println("1 . person main constructor")

  def this(name:String,age:Int,idNo:String) ={
    this(name,age)
    this.idNo = idNo
    println(s"2 . person[name=$name,age=$age,idNo=$idNo]")
  }

  def printInfo()={
    println("person ...")
  }
}

class Student(name:String,age:Int) extends Person(name,age) {

  var stdId:String = _
  println("3 . student main constructor")

  def this(name:String,age:Int,stdId:String)={
    this(name,age)
    this.stdId = stdId
    println(s"4 . student[name=$name,age=$age,stdId=$stdId]")
  }

  override def printInfo()={
    println("student ...")
  }
}
