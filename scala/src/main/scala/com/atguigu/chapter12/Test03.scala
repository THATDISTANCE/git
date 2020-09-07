package com.atguigu.chapter12

object Test03 {
  def main(args: Array[String]): Unit = {

//    var x : Int = 2
//
//    x match {
//      case 3 => println("this is a "+x)
//      case _ => println("this is other number")
//    }

    val v1 : Int = 20
    val v2 : Int = 4

    def t1(op:Any) = {
      op match {
        case '+' => v1 + v2
        case '-' => v1 - v2
        case '*'  => v1 * v2
        case '/' => v1 / v2
        case _ => "error"
      }
    }

    println(t1('+'))
    println(t1('-'))
    println(t1('*'))
    println(t1('/'))
    println(t1('?'))


    def abs(num:Int)={
      num match {
        case t if t > 0 => t
        case t if t < 0 => -t
        case _ => 0
      }
    }

    println(abs(-10))
    println(abs(29))
    println(abs(0))
  }
}
