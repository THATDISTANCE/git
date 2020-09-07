package com.atguigu.bigdata.sql.sql04

import java.net.{ServerSocket, Socket}

object Test08 {
  def main(args: Array[String]): Unit = {

    val socket = new Socket("localhost",9999)
    val output = socket.getOutputStream

    val arr = Array[Byte](1,2,3,4)
    output.write(arr)

    output.close()

  }
}
