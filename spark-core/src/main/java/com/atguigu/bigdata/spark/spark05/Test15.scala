package com.atguigu.bigdata.spark.spark05

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Test15 {
  def main(args: Array[String]): Unit = {

    // TODO Spark 转换算子
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    // TODO 计算所有分区最大值求和（分区内取最大值，分区间最大值求和）
    val rdd = sc.makeRDD(
      List(1,3,5,4,2,6),3
    )
    val rdd1 = rdd.glom()
    val rdd2 = rdd1.map(x=>x.max)
    println(rdd2.collect.sum)


    sc.stop()


  }
}
