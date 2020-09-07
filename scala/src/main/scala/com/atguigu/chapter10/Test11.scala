package com.atguigu.chapter10

object Test11 {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4,5,6,7,8,9)
//    println(list.filter(_ % 2 == 0))
//    println("=================")
//
//    println(list.map(_+": hello"))

//    val v1: List[List[Any]] = List(List(1,2,3),List(4,5),List(6,7,8,9))
//    println(v1)
//    println(v1.flatten)

//    val v2: List[List[Any]] = v1.head :: v1.tail :: Nil
//    println(v2)

//    val v3 = v1.head ::: v1.tail
//    println(v3)

    val strs: List[String] = List( "hello world", "hello scala", "hello atguigu", "we study" )
    val v1: List[Array[String]] = strs.map(_.split(" "))
    val flatten = v1.flatten
    println(flatten)

    println(strs.flatMap(_.split(" ")))
    println(list.groupBy(_ % 2))


    val wordList: List[String] = List("china", "america", "alice", "canada", "japan")
    println(wordList.groupBy(_.charAt(0)))

  }
}
