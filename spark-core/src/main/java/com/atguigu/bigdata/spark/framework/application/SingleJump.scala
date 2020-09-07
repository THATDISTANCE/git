package com.atguigu.bigdata.spark.framework.application

import com.atguigu.bigdata.spark.framework.common.TSingleJump
import com.atguigu.bigdata.spark.framework.controller.SingleJumpController

object SingleJump extends App with TSingleJump{
  runEnv(){
    val con = new SingleJumpController
    con.disbatch()
  }
}
