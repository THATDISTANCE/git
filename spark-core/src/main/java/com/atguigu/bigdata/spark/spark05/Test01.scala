package com.atguigu.bigdata.spark.spark05

object Test01 {
  def main(args: Array[String]): Unit = {
//    val user: Test[User] = new Test[User]
//    val user1:Test[User] = new Test[Child]
//    val user1:Test[User] = new Test[Parent]

    List(new User(),new User())
  }
}

class Test[+T]{
  def consumer():Message[_ <: T]={
    null
  }
}

class Message[T]{
  var t:T = _
}



class Parent{}

class User extends Parent {}

class Child extends User {}
