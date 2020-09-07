package com.atguigu.chapter08

object Test05 {
  def main(args: Array[String]): Unit = {

    //    val v1 = new Array[Int](3)
    //    println(v1.length)
    //    println(v1.mkString(","))
//    println(arr.apply(3))
//    println(arr(3))
//    arr(0) = 11
//    arr.update(0,100)
//    println(arr.mkString(","))
//
//    println("===========================")

//    for(i <- arr){
//      println(i)
//    }

//    for(i <- 0 to arr.length-1){
//      println(arr(i))
//    }

//    for(i <- Arr.indices(arr)){
//      println(arr(i))
//    }

//    val iterator: Iterator[Int] = arr.iterator
//    while(iterator.hasNext){
//      println(iterator.next())
//    }
    val arr = Arr(4,2,3,4)


    val v1 = arr :+ 20
    val v2 = 20 +:arr

    v1.foreach(println)
    v2.foreach(println)
  }
}

object Arr{
  def apply(x:Int,xs:Int*):Array[Int]={
    val arr = new Array[Int](xs.length+1)
    arr(0) = x
    var i = 1
    for(x <- xs.iterator){
      arr(i) = x
      i+=1
    }
    arr
  }

  def indices(arr:Array[Int]):Range = 0 until arr.length
}
