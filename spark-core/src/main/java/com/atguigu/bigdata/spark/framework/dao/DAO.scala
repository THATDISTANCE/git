package com.atguigu.bigdata.spark.framework.dao

import com.atguigu.bigdata.spark.spark11.util.ScEnv
import org.apache.spark.rdd.RDD

class DAO extends TDAO {

  def readFile(path:String):RDD[String]={
    val sc = ScEnv.get()
    sc.textFile(path)
  }

}
