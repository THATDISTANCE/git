package com.atguigu.chapter08

object Test08 {
  def main(args: Array[String]): Unit = {

//    println(v1)

//    val v2 = v1 :+ 20
//    val v3 = 20 +: v1
//    println(v1)
//    println(v2)
//    println(v3)

//    println(v1.eq(v2))
//    println(v1 == v2)
    val v1: List[Int] = List(1,2,3,4)
    var t1 = v1 :: Nil
    val t2 = v1.::(50)
    println(t1)
    println(t2)

    var t3 = 5000 :: v1
    println(t3)

    val t4 = 20 :: 30 :: 40 :: 50 :: 60 :: Nil
    println(t4)

    var t5 = v1 :: t2
    println(t5)

    var t6 = v1 ::: t2
    println(t6)

    val t7 = v1 ++ t2
    println(t7)

    t7.foreach(x=>println(x+"\t"))
  }
}
