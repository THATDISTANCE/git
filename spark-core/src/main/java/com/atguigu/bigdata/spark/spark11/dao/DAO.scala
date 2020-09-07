package com.atguigu.bigdata.spark.spark11.dao

import com.atguigu.bigdata.spark.spark11.common.Tdao
import com.atguigu.bigdata.spark.spark11.service.Acc
import com.atguigu.bigdata.spark.spark11.util.ScEnv
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

class DAO extends Tdao{

   val sc: SparkContext = ScEnv.get()

   def read(path:String): RDD[String] = {
     sc.textFile(path)
  }

  def register(acc:Acc)={
    sc.register(acc)
  }

}
