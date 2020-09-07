package com.atguigu.chapter07

object Test02 {
  def main(args: Array[String]): Unit = {
//    val arr = new Array[Int](3)

    val arr2 = Array(1,2)
    println(arr2.mkString(","))

    val v3 = arr2 :+10

    println(v3.mkString(","))

    println(arr2.eq(v3))

    val value = 20 +: v3

    println(value.mkString(","))
//
//
//    def v1(xs:String*) = {
//      println("hello")
//      println(xs.length)
//    }
//
//    v1("hel","fe","3ie")


  }
}

trait A{
  var i = 10
  def v1()={
    println("hello")
  }
}


trait B{
  A =>

  var j = 10
  def v2()={
    println("world")
  }

}

class C extends B with A {
  def main(args: Array[String]): Unit = {

  }
  i = 20
  j = 30
  v1()
  v2()
}