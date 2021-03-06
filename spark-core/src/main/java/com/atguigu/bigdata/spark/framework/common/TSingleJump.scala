package com.atguigu.bigdata.spark.framework.common

import com.atguigu.bigdata.spark.framework.util.EnvUtil
import org.apache.spark.{SparkConf, SparkContext}

trait TSingleJump {

  def runEnv(master:String = "local[*]",appname:String = "Application")(op: =>Unit)={

    val conf = new SparkConf().setMaster(master).setAppName(appname)
    val sc = new SparkContext(conf)

    EnvUtil.set(sc)

    try{
      op
    }catch {
      case ex:Exception => println(ex)
    }

    sc.stop()
    EnvUtil.clear()
  }

}
