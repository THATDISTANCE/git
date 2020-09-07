package com.atguigu.bigdata.spark.spark05

import org.apache.spark.{SparkConf, SparkContext}

object Test08 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("hello")
    val sc = new SparkContext(conf)

    val logRdd = sc.textFile("spark-core/datas")
    var urlRdd = logRdd.map(
//      log=>{
//          val str = log.split(" ")
//          str(6)
//      }
      {_.split(" ")(6).toCharArray.length}
    )

    urlRdd.saveAsTextFile("spark-core/output")

    sc.stop()
  }
}
