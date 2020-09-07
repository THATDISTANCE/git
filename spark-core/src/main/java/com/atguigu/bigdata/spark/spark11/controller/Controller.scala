package com.atguigu.bigdata.spark.spark11.controller

import com.atguigu.bigdata.spark.spark11.common.Tcontroller
import com.atguigu.bigdata.spark.spark11.service.Service

class Controller extends Tcontroller{

  private val service = new Service

  def execute(): Unit = {
   service.process()
  }
}
