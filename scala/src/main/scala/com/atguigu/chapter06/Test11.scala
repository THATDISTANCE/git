package com.atguigu.chapter06

object Test11 {
  def main(args: Array[String]): Unit = {
    val box = new BigBox
    println(box.size)
    box.get
    box.put()
    println(box.color)

  }
}

abstract class Box{

  var size:Int
  var color:String = "red"

  def put()={
    println("boxing")
  }

  def get
}

class BigBox extends Box {

  var size: Int = 10

  def get: Unit = println("bigbox get method")

  //override def put(): Unit = println("this is bigbox ,  override method from box")

}
