package com.atguigu.chapter06

object Test17 {
  def main(args: Array[String]): Unit = {
    val b = new B("helo",18)
    b.insert()
  }
}

class User(var name:String,var age:Int)

trait A{

  _ : User=>

  def insert()={
    println("insert into "+this.name)
  }

}

class B(name:String,age:Int) extends User(name,age) with A{

}