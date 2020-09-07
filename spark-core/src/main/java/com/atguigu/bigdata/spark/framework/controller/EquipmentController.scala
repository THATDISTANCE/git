package com.atguigu.bigdata.spark.framework.controller

import com.atguigu.bigdata.spark.framework.service.EquipmentService

class EquipmentController extends TController {

  private val top10service = new com.atguigu.bigdata.spark.framework.service.Service

  private val service = new EquipmentService

  def disbatch(): Unit = {
    val top10 = top10service.execute()
    val result = service.analysis(top10)
    result.foreach(println)
  }

}
