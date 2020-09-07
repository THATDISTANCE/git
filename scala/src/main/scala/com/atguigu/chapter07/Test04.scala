package com.atguigu.chapter07

object Test04 {
  def main(args: Array[String]): Unit = {
    val test0 = new Test04
    test0.printInfo()
    println(test0)
  }
}

class Test04{
  def printInfo()={
    println(this)
  }
}
