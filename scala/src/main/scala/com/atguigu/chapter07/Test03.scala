package com.atguigu.chapter07

object Test03 extends App with UserDao with Hello {
  def main(args: Array[String]): Unit = {
    login(new User("lisi",18))
    sayHello()
  }

}

class User(var name:String,var age:Int){
  override def toString: String = name+","+age+"\t"
}

trait UserDao{
  def insert(user:User)={
    println(user+"hello world !!")
  }
}

trait Hello{
  def sayHello()={
    println("you are so beautiful girl")
  }
}

trait App{
  this : UserDao with Hello =>

  def login(user:User)={
    println(user.name)
    insert(user)
  }
}
