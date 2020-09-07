package com.atguigu.chapter12

import scala.collection.mutable

object Test02 {
  def main(args: Array[String]): Unit = {

//    val q = new mutable.Queue[String]()
//    val queue1: mutable.Queue[String] = mutable.Queue("scala","hello","world")
//
//    q += "hello" += "scala"
//    println(q)
//
//    q.dequeue()
//    println(q)

//    val stack: mutable.Stack[Int] = mutable.Stack()
//    stack.push(1)
//    stack.push(2)
//    println(stack)
//
//    stack.pop()
//    println(stack)

    val v1 = (1 to 100).map(x=>x match {case _  => Thread.currentThread().getName} )
    val v2 = (1 to 100).par.map(x=>x match {case _ => Thread.currentThread().getName})

    println(v1)
    println("============")
    println(v2)

  }
}
