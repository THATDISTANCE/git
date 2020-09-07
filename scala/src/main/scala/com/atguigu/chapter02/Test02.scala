package com.atguigu.chapter02

import scala.util.control.Breaks._

object Test02 {
  def main(args: Array[String]): Unit = {

    //    for(i <- 1 to 10){
    //      println(i)
    //    }
    //
    //    for(i <- 1 to 10 by 2){
    //      println(i.*(i))
    //    }

    //    for(i <- 1 to 10 ; if i%2==0){
    //      println(i)
    //    }

    //    for(i <- 1 to 10 ; j = 10 - i ){
    //      println(i+" , "+j)
    //    }

    //    val ints = for(i <- 1 to 10 by 2) yield i
    //    println(ints)
//    val ints = for (i <- 1 to 10 by 2) yield {
//      i * 2
//    }
//    println(ints)

//    for(i <- 1 to 10 reverse)
//      println(i)


//    try{
//      for(i <- 1 to 10){
//        if(i == 5){
//          throw new NullPointerException
//        }
//        println(i)
//      }
//    }catch{
//      case e => println("there are error appear")
//    }

//    Breaks.breakable(
//      for(i <- 1 to 10){
//        if(i == 5){
//          Breaks.break()
//        }
//        println(i)
//      }
//    )
//    println("end")

      breakable(
      for(i <- 1 to 10){
        if(i == 5){
          break()
        }
        println(i)
      }
    )
    println("end")
  }
}
