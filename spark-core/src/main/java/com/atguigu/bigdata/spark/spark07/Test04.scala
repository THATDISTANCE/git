package com.atguigu.bigdata.spark.spark07

import org.apache.spark.{SparkConf, SparkContext}

object Test04 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("exe")
    val sc = new SparkContext(conf)

    val rdd = sc.makeRDD(
      List(
        ("a", 1),("a", 5),("b", 2),
        ("a", 3),("b", 4),("b", 1)
      ),
      2
    )

//    val aggRdd = rdd.aggregateByKey(10)(_+_,_+_)
//    aggRdd.collect() foreach(println)

    val foldRdd = rdd.foldByKey(10)(_+_)
    foldRdd.collect() foreach(println)


    sc.stop()
  }
}
