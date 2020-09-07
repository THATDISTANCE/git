package com.atguigu.bigdata.spark.spark11.common

import org.apache.spark.rdd.RDD

trait Tdao {

  def read(path:String):RDD[String]

  def read()={}

}
