package com.atguigu.bigdata.spark.spark03

object Test04 {
  def main(args: Array[String]): Unit = {

    implicit var pwd : String = "1111"

    def regUser(implicit pwd:String = "000000")={
      println(s"the password is $pwd")
    }

    regUser

  }
}
