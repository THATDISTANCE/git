package com.atguigu.bigdata.spark.spark11.application

import com.atguigu.bigdata.spark.spark11.common.Tapp
import com.atguigu.bigdata.spark.spark11.controller.Controller

object Application extends App with Tapp{
  runApp()(
    new Controller().execute()
  )
}
