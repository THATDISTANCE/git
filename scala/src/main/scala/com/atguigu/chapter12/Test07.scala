package com.atguigu.chapter12

object Test07 {
  def main(args: Array[String]): Unit = {
//    val list = List(("a", 1), ("b", 2), ("c", 3))
//    list.map(x=>(x._1,x._2 * 2))
//
////    list.map( _ match {case (a,t) => (a,t *2) })
//    list.map{case (a,b) => (a,b * 2) ; case _ => 'error}

    def positiveAbs() : PartialFunction[Int,Int]= {
      case x if x > 0 => x
    }

    def negativeAbs() :PartialFunction[Int,Int]={
      case y if y < 0 => -y
    }

    def zeroAbs():PartialFunction[Int,Int]={
      case z if z==0 => z
    }

    def fullAbs(x: Int)={
      (positiveAbs().orElse(negativeAbs().orElse(zeroAbs()))) (x)
    }


    println(fullAbs(-5))
    println(fullAbs(8))
    println(fullAbs(0))

  }
}
