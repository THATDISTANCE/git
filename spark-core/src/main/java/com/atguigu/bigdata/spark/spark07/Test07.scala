package com.atguigu.bigdata.spark.spark07

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test07 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    // TODO KV类型的数据操作
    val rdd = sc.makeRDD(
      List(("a", 88), ("b", 95), ("a", 91), ("b", 93), ("a", 95), ("b", 98))
    )

//    val redRdd : RDD[(String,Int)]= rdd.reduceByKey(_+_)

//    val redRdd = rdd.aggregateByKey(0)(_+_,_+_)

    val redRdd = rdd.combineByKey(
      x => x,
      (x: Int, y: Int) => (x + y),
      (x: Int, y: Int) => (x + y)
    )

    redRdd.collect() foreach(println)

  }
}
