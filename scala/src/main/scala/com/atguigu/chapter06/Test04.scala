package com.atguigu.chapter06

object Test04 {
  def main(args: Array[String]): Unit = {
    val women = new Women()
    println(women.name+" , "+women.age)
    women.peopleInfo()
  }

}

class Women extends Person{
  age = 20
  name = "张大炮"
  override def peopleInfo()={
    println("hello , you are loser  ,  dude  ,  blabla")
  }
}

class Person{

  var age:Int = 10
  var name:String = _

  def peopleInfo()={
    println(s"age=$age,name=$name")
  }

}
