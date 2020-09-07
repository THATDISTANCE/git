package com.atguigu.bigdata.spark.spark05

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test13 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(
      List(List(1,2),3,List(4,5))
    )

    var iRdd : RDD[Int] = rdd.flatMap{
      case x => 3::Nil
      case list:List[Int] => list
    }

    iRdd.collect() foreach println

    sc.stop()
  }
}
