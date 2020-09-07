package com.atguigu.chapter06

object Test16 {
  def main(args: Array[String]): Unit = {
    val ball = new MyBall
    println(ball.describe())
  }
}


trait Ball{
  def describe()={
    "ball"
  }
}

trait color extends Ball{

  var color : String = "red"

  override def describe(): String = color+"-"+super.describe()

}

trait category extends Ball{

  var category:String = "play"

  override def describe(): String = category+"-"+super.describe()

}

class MyBall extends color with category{
  override def describe(): String = super.describe()
}

