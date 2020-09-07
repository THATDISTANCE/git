package com.atguigu.bigdata.spark.spark07

import org.apache.spark.{SparkConf, SparkContext}

object Test18 {
  def main(args: Array[String]): Unit = {

    // TODO Spark 行动算子
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    // TODO Save* 保存文件
    val rdd = sc.makeRDD(List(1,2,3,4), 2)

    rdd.saveAsTextFile("spark-core/datas/out1")
    rdd.saveAsObjectFile("spark-core/datas/out2")
    rdd.map((_,1)).saveAsSequenceFile("spark-core/datas/out3")

  }
}
