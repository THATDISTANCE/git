package com.atguigu.chapter06

object Test05 {

  def main(args: Array[String]): Unit = {
    new person()
    new dude().printinfo()
  }

}

class dude extends person {
  name = "hello"
  def printinfo()={
    println(name)
  }
}

class person{

  private var idCardNo: String = "123456"
  protected var name: String = "alice"
  private[chapter06] var age: Int = 18
  var sex: String = "female"

  def printInfo()={
    println("hello , world !!!!!")
  }

}
