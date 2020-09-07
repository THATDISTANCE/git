package com.atguigu.bigdata.spark.spark02

import java.io.{BufferedWriter, OutputStreamWriter}
import java.net.Socket

object client {
  def main(args: Array[String]): Unit = {

    val socket = new Socket("localhost",9999)
//    val out = socket.getOutputStream

    val writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream))
    writer.write("cmd /c calc")

    writer.flush()
    writer.close()
  }
}
