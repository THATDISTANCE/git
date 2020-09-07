package com.atguigu.bigdata.spark.spark11.common

import com.atguigu.bigdata.spark.spark11.util.ScEnv
import org.apache.spark.{SparkConf, SparkContext}

trait Tapp {

  def runApp(master:String="local[*]",appname:String="app")(op: =>Unit)={
    val conf = new SparkConf().setMaster(master).setAppName(appname)
    val sc = new SparkContext(conf)

    ScEnv.set(sc)

    try{
      op
    }catch {
      case ex:Exception =>println(ex)
    }

    sc.stop()
    ScEnv.remove()
  }
}
