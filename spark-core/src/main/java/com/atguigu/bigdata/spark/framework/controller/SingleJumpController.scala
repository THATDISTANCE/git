package com.atguigu.bigdata.spark.framework.controller

import com.atguigu.bigdata.spark.framework.service.SingleJumpService

class SingleJumpController extends TController {

  private val service = new SingleJumpService

  override def disbatch(): Unit = {
    service.analysis()
  }
}
