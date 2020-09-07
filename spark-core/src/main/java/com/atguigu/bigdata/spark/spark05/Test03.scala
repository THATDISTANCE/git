package com.atguigu.bigdata.spark.spark05

object Test03 {
  def main(args: Array[String]): Unit = {

//    implicit def transform(double: Double)={
//      double.toInt
//    }
//
//    var i :Double = 10
//    var j : Int = i
    val user = new User() with UserExt
    user.read()
    user.write()

//    implicit def transform(user:User):UserExt={
//      new UserExt
//    }

  }

  class User{
    def read()={
      println("read ...")
    }
  }

  trait UserExt{
    def write()={
      println("write ...")
    }
  }

}
