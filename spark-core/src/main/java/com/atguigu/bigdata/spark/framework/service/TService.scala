package com.atguigu.bigdata.spark.framework.service

import org.apache.spark.rdd.RDD

trait TService {

  def analysis(data:Any):RDD[(Long, List[(String, Int)])]={
    null
  }
  def analysis()={

  }
}
