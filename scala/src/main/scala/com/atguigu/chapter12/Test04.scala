package com.atguigu.chapter12

object Test04 {
  def main(args: Array[String]): Unit = {
//    def v1(t:Any)={
//      t match {
//        case i:Int => println("int")
//        case d:Double => println("double")
//        case b:Boolean => println("true or false")
//        case a:Array[String] => println("array[string]")
//        case l:List[String] => println("list[string]")
//        case _ => println("unit type")
//      }
//    }
//
//    println(v1(1))
//    println(v1(1.3))
//    println(v1(true))
//    println(v1(Array("a", "b", "c")))
//    println(v1(List("e", "f", "g")))
//    println(v1('_'))

//    def describeType(x: Any) = x match {
//      case i: Int => "Int " + i
//      case s: String => "String " + s
//      case l: List[Int] => "List " + l
//      case arr: Array[Int] => "Array " + arr.mkString(",")
//
//      // 默认情况：一般是用_，也可以用一个变量（没有类型）来接收当前的值
//      case abc => "something else " + abc
//    }
//
//    println(describeType(23))
//    println(describeType("hello"))
//    println(describeType(List("a", "b", "c")))
//    println(describeType(List(1, 2, 3, 4))) // 正常匹配List，泛型擦除
//    println(describeType(Array("a", "b", "c")))
//    println(describeType(Array(1, 2, 3, 4))) // Array[Int] --> int[]

    // NORMAL MATCH LIST , TYPE ERASER

//    for (elem <- List(
//      Array(0),
//      Array(0, 1),
//      Array(1, 0),
//      Array(0, 1, 0),
//      Array(1, 1, 1),
//      Array(2, 15, 37),
//      Array("hello", 56, 7.9)
//    )) {
//      val res = elem match {
//        case Array(0) => "0"
//        case Array(0,_) => "以0开头的数组"
//        case Array(1,_) => "以1开头的数组"
//        case Array(0,1,_) => "以0,1开头的数组"
//        case Array(_,_,1) => "末尾是1"
//        case Array(2,_,_) => "以2开头"
//        case Array(_,_,_) => "以字符串开头"
//        case _ => "none"
//      }
//      println(res)
//    }

//    for (elem <- List(
//      List(0),
//      List(25),
//      List(0, 1),
//      List(1, 0),
//      List(0, 1, 0),
//      List(1, 1, 1),
//      List(2, 15, 37),
//      List("hello", 56, 7.9)
//    )) {
//      val res = elem match {
//        case List(0) => "0"
//        case List(a,b) => "dual parameter"
//        case List(0,_*) => "three paremeter"
//        case List(_,_,1) => "last is 1"
//        case List(2,_,_) => "the head is 2"
//        case List(_*) => "fafaf"
//        case _ => "something else"
//      }
//      println(res)
//    }
//    val v1 = List(2,1)
//
//    val res = v1 match {
//      case first :: 1 :: second => "the second number is two"
//      case _ => "something else"
//    }
//    println(res)

    for (elem <- List(
      (0, 1), (0, 0), (1, 0), (1, 1), (1, 0, 2)
    )) {
      val res = elem match {
        case (0,_) => "zero head"
        case (y,0) => "0,0"
        case (1,x) => "1,0"
        case (_,_) => "1,1"
        case _ => "something else"
      }
      println(res)
    }
  }
}
