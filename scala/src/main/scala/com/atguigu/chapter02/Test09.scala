package com.atguigu.chapter02

object Test09 {
  def main(args: Array[String]): Unit = {
//    def v1(a:Int,b:String,c:Char) = !(a==0 && b == "" && c == '0')
//    println(v1(0, "", '0'))

//    val b = ((a:Int,b:String,c:Char)=> !(a == 0 && b == "" && c == '0')) (0,"",'0')
//    println(b)

//    val fun: (Int, String, Char) => Boolean = (a:Int,b:String,c:Char) => !(a==0&&b==""&&c=='0')
//    println(fun(0, "", '0'))

//    def v1(a:Int):String=>(Char=>Boolean)={
//      def v2(b:String):Char=>Boolean={
//        def v3(c:Char):Boolean={
//          !(a==0&&b==""&&c=='0')
//        }
//        v3
//      }
//      v2
//    }
//
//    println(v1(0)("")('0'))
//    println(v1(0)("")('1'))

//    def v1(a:Int):String=>(Char=>Boolean)={
//      b=>(c => !(a==0&&b==""&&c=='0'))
//    }
//
//    println(v1(0)("")('0'))

    def v1(a : Int):String=>(Char=>Boolean)={
      b=>(c=> !(a==0&&b==""&&c=='0'))
    }

    println(v1(0)("")('0'))

  }
}
