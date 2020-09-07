package com.atguigu.chapter01

object Test14 {
  def main(args: Array[String]): Unit = {

    var i = 5

//    while( i >= 1){
//      println(i)
//      i-=1
//    }

    do{
      println(i)
      i-=1
    }while(i >= 1)

  }
}
