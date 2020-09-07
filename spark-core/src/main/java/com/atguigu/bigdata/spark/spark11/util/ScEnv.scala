package com.atguigu.bigdata.spark.spark11.util

import org.apache.spark.SparkContext

object ScEnv {
  private val tmp = new ThreadLocal[SparkContext]

  def set(sc:SparkContext)={
    tmp.set(sc)
  }

  def get()={
    tmp.get()
  }

  def remove()={
    tmp.remove()
  }
}
