package com.atguigu.chapter08

object Test07 {
  def main(args: Array[String]): Unit = {

    val arr = Array.ofDim[Int](2,3)
    arr(0)(0) = 100
    arr(1)(2) = 200

//    for(i <- 0 until arr.length ; j <- 0 until arr(i).length){
//      println(arr(i)(j))
//    }

//    for(i <- arr.indices ; j <- arr(i).indices){
//      print(arr(i)(j)+"\t")
//      if(j == arr(i).length -1) println()
//    }
//
//    arr.foreach(x=>x.foreach(x=>println(x)))

    arr.foreach(_.foreach(println))


  }
}
