package com.atguigu.chapter07

object Test05 {
  def main(args: Array[String]): Unit = {

//    val v1 = new Array[Int](3)
//    val v2 = new ArrayBuffer[Int]()
//
//    val v3 = Array(1,2,3)
//    val v4 = ArrayBuffer(1,2,3)
//
//    val v5 = 20 +: v4
//    val v6 = v4 :+ 20
//
//    println(v5.mkString(","))
//    println(v6.mkString(","))
//
//    println(v6)
//    val v7 = v6.toArray
//    val v8 = v7.toBuffer
//    println(v8.mkString(","))
//    println(v8)

    val v1: Array[Array[Int]] = Array.ofDim[Int](2,3)

    v1(0)(2) = 10
    v1(1)(0) = 20

//    for(i <- 0 until v1.length ; j <- 0 until v1(i).length){
//      println(v1(i)(j))
//    }


//    for(i <- v1.indices ; j <- v1(i).indices){
//      println(v1(i)(j))
//    }

    //    v1 foreach(_.foreach(println))
    //    val v1 = Array(1,2,3,4,5)
    //    for(i <- v1.iterator){
    //      println(i)
    //    }



//    for(i <- v1.iterator ; j <- v1(i).iterator){
//      v1(i)(j)
//    }



  }
}
