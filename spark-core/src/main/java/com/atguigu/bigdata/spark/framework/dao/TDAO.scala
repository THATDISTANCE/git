package com.atguigu.bigdata.spark.framework.dao

import org.apache.spark.rdd.RDD

trait TDAO {

  def readFile(path:String):RDD[String]

}
