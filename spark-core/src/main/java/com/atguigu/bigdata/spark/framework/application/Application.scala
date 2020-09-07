package com.atguigu.bigdata.spark.framework.application

import com.atguigu.bigdata.spark.framework.common.TApplication
import com.atguigu.bigdata.spark.framework.controller.Controller

object Application extends App with TApplication{

  runEnv()(new Controller().disbatch())

}
