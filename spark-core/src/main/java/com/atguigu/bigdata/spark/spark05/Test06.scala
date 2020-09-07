package com.atguigu.bigdata.spark.spark05

import org.apache.spark.{SparkConf, SparkContext}

object Test06 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("hello")
    val sc = new SparkContext(conf)

    def transform(i:Int)={
      i+"===>"
    }

    val rdd = sc.parallelize(List(1,2,3,4,5),3)
    val value = rdd.map(transform)
    value.collect() foreach println


    value.saveAsTextFile("spark-core/output")

    sc.stop()
  }
}
