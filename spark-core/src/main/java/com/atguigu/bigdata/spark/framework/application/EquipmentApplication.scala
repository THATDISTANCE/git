package com.atguigu.bigdata.spark.framework.application

import com.atguigu.bigdata.spark.framework.common.TEquipmentApplication
import com.atguigu.bigdata.spark.framework.controller.EquipmentController

object EquipmentApplication extends App with TEquipmentApplication{

  runEnv(){
    val con = new EquipmentController
    con.disbatch()
  }

}
