package com.atguigu.chapter10

import scala.collection.mutable.ListBuffer

object Test04 {
  def main(args: Array[String]): Unit = {

    val v1 = new ListBuffer[Int]
    v1 += 3 += 3

    30 +=: 40 +=: 50 +=: v1

    println(v1)

    val v2 = ListBuffer(11,22,33,44)

    println("====================r=======")

    val t1 = v1 ++ v2
    println(v1)
    val t2 = v1 ++= v2
    val t3 = v1 ++=: v2

    println(t1)
    println(t2)
    println(t3)

    println("======================p========================")

    println(v1)

    v1 -= 30

    println(v1)

    val ints = v1 - 3

    println(ints)
    println(v1)

  }
}
