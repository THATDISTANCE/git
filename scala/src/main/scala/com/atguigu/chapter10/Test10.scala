package com.atguigu.chapter10

object Test10 {
  def main(args: Array[String]): Unit = {

    val list = List(5,1,8,2,-30,4)
//    var sum = 0
//    for (elem <- list) {
//      sum += elem
//    }
//    println(sum)

//    println(list.sum)
//    println(list.product)
//    println("=================")
//    println(list.max)
//    println(list.maxBy(_.abs))
    println(list.sorted)
    println(list.sorted.reverse)
    println("=======================")

    println(list.sortBy(_.abs))
    println(list.sortBy(_.abs).reverse)

    println(list.sortWith(_ > _).reverse)
  }
}
