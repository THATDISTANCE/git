package com.atguigu.bigdata.spark.spark06

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test15 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(
      List(
        ("a", 1),("a", 5),("b", 2),
        ("a", 3),("b", 4),("b", 1)
      ),
      2
    )

    val aggRdd : RDD[(String,Int)]= rdd.aggregateByKey(0)(
      ((a, b) => math.max(a,b)),
      ((a, b) => a + b)
    )
    aggRdd.collect() foreach println




  }
}
