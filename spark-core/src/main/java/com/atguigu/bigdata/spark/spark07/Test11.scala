package com.atguigu.bigdata.spark.spark07

import org.apache.spark.{SparkConf, SparkContext}

object Test11 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    val rdd1 = sc.makeRDD(List(
      ("a", 1), ("b",2), ("c", 3), ("d", 4)
    ))

    val rdd2 = sc.makeRDD(List(
      ("a", 4), ("b",5), ("c", 6), ("a", 7)
    ))

//    rdd1.join(rdd2).collect() foreach(println)

//    rdd1.leftOuterJoin(rdd2).collect() foreach(println)

    rdd1.cogroup(rdd2).collect() foreach(println)



  }
}
