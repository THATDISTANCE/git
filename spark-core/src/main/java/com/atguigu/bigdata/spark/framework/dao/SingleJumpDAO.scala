package com.atguigu.bigdata.spark.framework.dao
import com.atguigu.bigdata.spark.framework.util.EnvUtil
import org.apache.spark.rdd.RDD

class SingleJumpDAO extends TDAO {

  override def readFile(path: String): RDD[String] = {
    EnvUtil.get().textFile(path)
  }

}
