package com.atguigu.bigdata.spark.spark05

object Test05 {
  def main(args: Array[String]): Unit = {

//    var a :String = "a"
//
//    a match {
//      case "a" => println("aaaaaa")
//      case _ => println("bbbbbb")
//    }

//    val a1 : Any = "zhangsan"
//    val a2 : Any = Array(1,2,3,4)
//    val a3 : Any = Array("a","b","c")
//    val a4 : Any = List("a","b","c")
//
//    a4 match {
//      case i:Int => println("int")
//      case s:String => println("string")
//      case arr:Array[String] => println("array string")
//      case list:List[Int] => println("list")
//      case _ => println("other")
//    }

//    val (_ , second , third) = (1,"hello",18)
//
//    println(s"1,$second,$third")

    val list = Map("a"->1,"b"->2,"c"->3)
//    for ((first,second) <- list) {
//      println(s"$first,$second")
//    }

//    for ((_,second) <- list) {
//      println(s"$second")
//    }

//    for (("a",second) <- list) {
//      println(second)
//    }

    list.foreach {
      case ("a",second) => println(s"hello,$second")
      case (a,b) => println(s"$a,$b")
    }


    //here , foreach is very useful than map , note that prior to consider foreach before use map


  }
}
