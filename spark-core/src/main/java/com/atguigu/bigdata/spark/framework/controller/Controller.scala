package com.atguigu.bigdata.spark.framework.controller

import com.atguigu.bigdata.spark.framework.service.Service

class Controller extends TController {

  private val ser = new Service

  override def disbatch(): Unit = {
    val result = ser.execute()
    result.foreach(println)
  }

}
