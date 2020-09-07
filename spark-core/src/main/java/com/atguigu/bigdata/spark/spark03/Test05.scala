package com.atguigu.bigdata.spark.spark03

object Test05 {
  def main(args: Array[String]): Unit = {

    new A().read()
    new A().write()


  }

  implicit class B(a: A){
    def read()={
      println("read .. ")
    }
  }


  class A {
    def write()={
      println("print .. ")
    }
  }

}
