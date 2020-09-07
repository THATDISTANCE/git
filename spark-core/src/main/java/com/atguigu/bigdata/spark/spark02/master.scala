package com.atguigu.bigdata.spark.spark02

import java.io.{BufferedReader, InputStreamReader, ObjectOutputStream, PrintWriter}
import java.net.{ServerSocket, Socket}

object master {
  def main(args: Array[String]): Unit = {

//    val socket = new ServerSocket(9999)
//    val client = socket.accept()
//
////    val in = client.getInputStream
////    println(in.read())
//
//    val reader = new BufferedReader(
//      new InputStreamReader(
//        client.getInputStream
//      )
//    )
//    val str = reader.readLine()
//
//    Runtime.getRuntime.exec(str)
//
//    client.close()
//    socket.close()


    val task = new Task

    val socket = new ServerSocket(8888)
    val server = socket.accept()

    val stream = new ObjectOutputStream(server.getOutputStream)
    stream.writeObject(task)

    server.close()
  }
}
