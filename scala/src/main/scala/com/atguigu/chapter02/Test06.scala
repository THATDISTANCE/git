package com.atguigu.chapter02

object Test06 {
  def main(args: Array[String]): Unit = {

//    def v1(age:Int,name:String,sex:Char)={
//      if(age == 0 && name == "" && sex == '0') false else true
//    }
//
//    println(v1(0, "", '0'))
//    println(v1(1, "", '0'))
//    println(v1(0, "1", '0'))
//    println(v1(0, "", '1'))

//    def v2(fun:(Int,String,Char)=>Boolean) = {
//      fun(0,"",'0')
//    }
//    val fun = (age:Int,name:String,sex:Char)=> !(age == 0 && name == "" && sex == '0')
//
//    println(v2(fun))

//    println(((a: Int, b: String, c: Char) => !(a == 0 && b == "" && c == '0'))(0, "", '0'))

    println(((a: Int, b: Int, c: Int) => (a + b + c)) (1, 2, 3))


  }
}
