package com.atguigu.chapter10

object Test09 {
  def main(args: Array[String]): Unit = {

    val list1 = List(1,2,3,4,5,6,7)
    val list2 = List(4,5,6,7,8,9,10,11,12,20)

    println(list1.head)
    println(list1.last)
    println(list1.tail)
    println(list1.init)
    println(list1.reverse)

    println(list1.take(3))
    println(list1.takeRight(3))
    println(list1)

    val v1: List[Int] = list1.union(list2)
    val v2 = list1 ++ list2
    println(v2)
    println(v1)

    println("==========================")
    println(list1.intersect(list2))
    println(list2.intersect(list1))

    println("========================")
    println(list1.diff(list2))
    println(list2.diff(list1))

    println(list1.zip(list2))
    println(list2.zip(list1)) //this is a group of zip , example: list(1,2,3) , list(2,3)    list((1,2),(2,3)

    println("====================")
    for (elem <- list1.sliding(3,3)) {
      println(elem)
    }

  }
}
