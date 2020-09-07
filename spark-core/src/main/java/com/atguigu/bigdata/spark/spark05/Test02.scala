package com.atguigu.bigdata.spark.spark05

object Test02 {
  def main(args: Array[String]): Unit = {

    implicit val i:String = "look"

    def regUser(implicit pwd:String="000000")={
      println(pwd)
    }

    regUser

  }
}
