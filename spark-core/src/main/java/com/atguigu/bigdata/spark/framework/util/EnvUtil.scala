package com.atguigu.bigdata.spark.framework.util

import org.apache.spark.SparkContext

object EnvUtil {
  private val pool = new ThreadLocal[SparkContext]

  def set(sc: SparkContext)={
    pool.set(sc)
  }

  def get()={
    pool.get()
  }

  def clear()={
    pool.remove()
  }
}
