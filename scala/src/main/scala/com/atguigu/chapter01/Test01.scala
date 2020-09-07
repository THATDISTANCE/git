package com.atguigu.chapter01

import java.io.{File, PrintWriter}

import scala.io.Source

object Test01 {
  def main(args: Array[String]): Unit = {

    Source.fromFile("scala/src/main/resources/hello.txt")
      .foreach(print)

//    val writer = new PrintWriter(new File("scala/src/main/resources/1.txt"))
//    writer.write("hello")
//    writer.write("what are you doing")
//    writer.write("this is a scala programming language")
//    writer.close()

    Source.fromFile("scala/src/main/resources/1.txt").foreach(
      x => println(x)
    )

  }
}
