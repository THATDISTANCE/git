//package com.atguigu.chapter09
//
//import scala.collection.mutable
//import scala.collection.mutable.ListBuffer
//
//object Test03 {
//  def main(args: Array[String]): Unit = {
//    val v1 = new ListBuffer[Int]
//    v1.append(12,23)
//    println(v1)
//
//    println(v1)
//
////    def v1 :this.type= {
////      println(this)
////      this
////    }
////    println("============================")
////
////    val test0 = new Test03
////    println(test0.v)
////    println(test0)
//
////    println("============================")
////
////    val test0 = new Test11111
////    println(test0.v)
////    println(test0)
//
//
//  }
//}
//
//class Test03[Int] extends ListBuffer with A[Int] {
//  private val buf: Test03[Int] = Test03[Int]
//
//  override def ++=(elem: Int*): A[Int] = {
//    buf.prependAll(elem)
//    buf
//  }
//}
//
//trait A[T]{
//
//  def append(elem:T*): A[T] = {
//    this ++= elem
//    this
//  }
//
//
//  def ++=(elem: Seq[T]) : A[Int]{
//
//  }
//}
//
//
