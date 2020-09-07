package com.atguigu.bigdata.sql.sql04

import java.net.{ServerSocket, Socket}

object Test09 {
  def main(args: Array[String]): Unit = {

    val server = new ServerSocket(9999)
    val socket: Socket = server.accept()

    val input = socket.getInputStream

    var i = 0

    while((i = input.read()) != -1){
      println(i)
    }

  }
}
