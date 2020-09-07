package com.atguigu.bigdata.spark.spark06

object Test01 {
  def main(args: Array[String]): Unit = {

    def v1(a:Int):Int=>Int={
      def v2(b:Int)={
        a+b
      }
      v2 _
    }

    v1(1)(2)

  }
}
