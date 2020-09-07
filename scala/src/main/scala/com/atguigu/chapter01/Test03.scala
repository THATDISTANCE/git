package com.atguigu.chapter01

object Test03 {
  def main(args:Array[String]):Unit={
    val i:Boolean = test()
  }

  def test():Nothing={
    throw new NullPointerException
  }
}

class Test03{

}