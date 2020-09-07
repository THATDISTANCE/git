package com.atguigu.chapter02

object Test04 {
  def main(args: Array[String]): Unit = {
    say(sex = "male" , name = "1",age = 12331)
  }

  def say(name:String = "atguigu",age:Int = 12 , sex:String): Unit ={
    println(name+" , "+age+ " , "+ sex)
  }
}
