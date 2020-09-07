package com.atguigu.chapter01

import scala.collection.immutable.StringOps
import scala.io.StdIn

object Test05 {
  def main(args: Array[String]): Unit = {

    val age = StdIn.readInt()

    val value: Any = if ( age < 18 ){
      val ops = new StringOps("hello")
      ops
    }else{
      "壮年"
    }
//    print(value)

    val value1: Comparable[String] = if( age < 18 ) {var i = new StringOps("hello11"); i} else "world"
    println(value1)

  }
}
