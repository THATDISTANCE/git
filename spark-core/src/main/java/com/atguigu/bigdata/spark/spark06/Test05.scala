package com.atguigu.bigdata.spark.spark06

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test05 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("test")
    val sc = new SparkContext(conf)

//    val list = List("Hello", "hive", "hbase", "Hadoop")
//    val preRdd = sc.makeRDD(list,2)
//    val groupRdd:RDD[(Char,Iterable[String])] = preRdd.groupBy(x=>x(0))
//    groupRdd.collect() foreach(println)


    val rdd = sc.textFile("spark-core/datas/apache.log")

    val strRdd : RDD[String] = rdd.map((_.split(" ")(3)))
    val groupRdd : RDD[(String,Iterable[String])]= strRdd.groupBy(time=>{
      val hour = time.substring(11,13)
      hour
    })
    groupRdd.collect() foreach(println)

    sc.stop()
  }
}
