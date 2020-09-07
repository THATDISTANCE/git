package com.atguigu.chapter06

object Test15 {
  def main(args: Array[String]): Unit = {
//    val stu1 = new student101
//    println(stu1.name)
//    stu1.look()
//    println(stu1.age)
//    stu1.run()
//    stu1.addKnowledge
//    stu1.singing
//    stu1.playing

    val v = new ZYX with talent{

      override def singing: Unit = println("singing")

      override def playing: Unit = println("playing")
    }

    v.playing
    v.singing

  }
}

trait talent{
  def singing
  def playing
}

trait knowledge{
  def addKnowledge
}

class Person101{
  var name:String = "张艺馨是沙雕"
  def look()={}
}

class student101 extends Person101 with knowledge with talent {
  var age:Int = 100
  def run()={
    println("running")
  }

  override def look(): Unit = println("it is a beautiful night , how is one to do ")

  override def addKnowledge: Unit = println("add knowledge")

  override def singing: Unit = println("singing")

  override def playing: Unit = println("playing")
}

class ZYX{

}