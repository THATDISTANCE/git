package com.atguigu.chapter08

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Test06 {
  def main(args: Array[String]): Unit = {

    val v1 = new ArrayBuffer[Int]()
    val v2 = ArrayBuffer(4,3,2,1)
    val v3 = ArrayBuffer[Int]()

//    println(v2(0))
//    v2.update(2,33)
//    for(x <- v2) print(x+"\t")

//    val v3 = v2.+:(30)
//
//    println(v3==v2)
//    println(v3.eq(v2))

//    val v = v2 += 20
//    v.foreach(println)
//    println(v.equals(v2))
//    println(v.eq(v2))
    v2.append(10,20)
    v2.prepend(5,10)
    v2.insert(1,3,4)

//    v2.foreach(x=>print(x+"\t"))

    v2.remove(1,2)

//    for(x <- v2){
//      print(x+"\t")
//    }

    v3.prependAll(v2)

//    v3.foreach(x=>print(x+"\t"))

    val t1: Array[Int] = v3.toArray
    print(t1.mkString(","))
    println("===========================")
    println(v3.mkString(","))
    println(t1)

    val t2: mutable.Buffer[Int] = t1.toBuffer
    println(t2)
  }
}


