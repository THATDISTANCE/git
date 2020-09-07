package com.atguigu.chapter11

object Test06 {
  def main(args: Array[String]): Unit = {

    implicit var str:String = "hello .. "

    def v1(implicit name:String = "hello")={
      println(name)
    }

    v1()
    v1
  }
}
