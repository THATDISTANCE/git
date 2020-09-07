package com{

  import com.atguigu.chapter06.Inner

  object Outer {

    var out:String = "out......."

    def main(args: Array[String]): Unit = {
      println("out=="+out)
      println(Inner.in)
    }

  }

  package atguigu{
    package chapter06{
      object Inner {
        var in:String = "in......."

        def main(args: Array[String]): Unit = {
          println("in=="+in)
          println(Outer.out)
        }
      }
    }
  }
}
//result: it is not allowed to invoke inner package from outer package point , on contrary , of course

package aaa{
  package bbb{

    import com.Outer
    import com.atguigu.chapter06.Inner

    object Test01{
      def main(args:Array[String])={

        println(Inner.in)
        println(Outer.out)

      }
    }
  }
}
