package com.atguigu.chapter01

object Test10 {
  def main(args: Array[String]): Unit = {
    for(i <- 1 to 9){
      print(" "*(9*2-i)+"*"*(i*2-1))
      println()
    }
  }
}
