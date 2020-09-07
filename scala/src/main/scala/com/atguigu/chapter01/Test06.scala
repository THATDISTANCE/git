package com.atguigu.chapter01

import scala.collection.immutable.StringOps
import scala.io.StdIn

object Test06 {
  def main(args: Array[String]): Unit = {

    val age = StdIn.readInt()

    val unit: AnyVal = if( age < 18 ){
      if( age < 15 ){
        val ops: StringOps = new StringOps("青年")
        ops
      }else{
        age
      }
    }else if(age < 30){
      var c = 'a'
      c
    }else{
      val ops: StringOps = new StringOps("hello")
      ops
    }
    println(unit)

  }
}
