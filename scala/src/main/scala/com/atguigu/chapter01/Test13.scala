  package com.atguigu.chapter01

  object Test13 {
    def main(args: Array[String]): Unit = {

  //    Breaks.breakable(
  //      for(i <- 1 to 10){
  //        if(i == 5){
  //          Breaks.break()
  //        }
  //        println(i)
  //      }
  //    )
  //    println("it is out")

      try{
        for( i <- 1 to 10){
        if(i == 5){
        throw new NullPointerException
      }
        println(i)
      }
      }catch {
        case ex : Exception =>
      }
        println("it is out")
      }
  }
