package com.atguigu.chapter03

import scala.beans.BeanProperty

object Test04 {
  def main(args: Array[String]): Unit = {

//    val t: Test04 = new Test04
//    println(t.namemmmmeee)
    v1()

    def v1(): Unit ={
      val t = new Test04
      println(t.namemmmmeee)
    }
  }
}

class Test04{

  private var namemmmmeee:String = "hellofafjaflaf"

  @BeanProperty
  var age1 : Int = 18

  private var age2 : Int = _

}
