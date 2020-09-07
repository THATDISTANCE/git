package com.atguigu.chapter03

object Test03 {
  def main(args: Array[String]): Unit = {

//        def v1(a:Int)(b:Char)(c:String)={
//          a == 0 && b == '0' && c == ""
//        }
//
//        var i1 = v1(0)(_)(_)
//        var i2 = i1('0',_)
//        var i3 = i2("")
//        println(i3)

//    def v1(a:Int)(b:Char)={
//      a == 0 && b == '0'
//    }
//
//    var i1 = v1(0)(_)
//    var i2 = i1('0')
//    println(i2)


//    def doWhile1(condition: =>Boolean): (=>Unit)=>Unit ={
//      def do1(op: =>Unit):Unit = {
//        if (condition){
//          op
//          do1(op)
//        }
//      }
//      do1
//    }
//
//    var n = 10
//    doWhile1( n>=1 )(
//      {println(n)
//      n-=1}
//    )

//    var n = 10
//    def doWhile2(condition: =>Boolean)(op: =>Unit):Unit={
//      if(condition){
//        op
//        doWhile2(condition)(op)
//      }
//    }
//    doWhile2( n >= 1)({println(n);n-=1})

//    def dowhile3(condition: =>Boolean)(op: =>Unit):Unit={
//      if(condition){
//        op
//        dowhile3(condition)(op)
//      }
//    }

//    def dowhile4(condition: =>Boolean)(op: =>Unit):Unit={
//      if(condition){
//        op
//        dowhile4(condition)(op)
//      }
//    }
//    var n = 10
//    dowhile4( n >= 1)({println(n);n-=1})

  }
}
