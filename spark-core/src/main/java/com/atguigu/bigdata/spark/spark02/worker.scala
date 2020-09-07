package com.atguigu.bigdata.spark.spark02

import java.io.ObjectInputStream
import java.net.Socket

object worker {
  def main(args: Array[String]): Unit = {
    val socket = new Socket("localhost",8888)
    val stream = socket.getInputStream
    val stream1 = new ObjectInputStream(stream)
    val str: Task = stream1.readObject().asInstanceOf[Task]
    println(str.compute().mkString(","))
  }
}
