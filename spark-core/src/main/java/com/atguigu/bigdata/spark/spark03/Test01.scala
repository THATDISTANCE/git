package com.atguigu.bigdata.spark.spark03

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test01 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("exe")
    val sc = new SparkContext(conf)

//    val rdd: RDD[String] = sc.wholeTextFiles("spark-core/datas")
//    println(rdd.first())
//    println(rdd.count())
//    println(rdd.filter(_.contains("Spark")).count())
//    println(rdd.map(_.split(" ").size).reduce((a,b)=>if (a>b) a else b))
//    println(rdd.map(_.split(" ").size).reduce(math.max(_, _)))
//    println(rdd.flatMap(_.split(" ")).groupBy(x => x).count())
//    println("==========================")
//    rdd.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).collect() foreach println
//    println("============test==============")
//    rdd.flatMap(_.split(" ")).groupBy(x=>x).map(a=>(a._1,a._2.size)).sortBy(_._2).collect().reverse foreach println
//    println("==========================")
//    rdd.flatMap(_.split(" ")).groupBy(x=>x).map(a=>(a._1,a._2.size)).collect().sorted foreach println
//    println("=============other=============")
//    rdd.cache()
//    rdd.flatMap(_.split(" ")).groupBy(x=>x).map(a=>(a._1,a._2.size)).sortBy(_._2).collect().reverse foreach println
    sc.stop()

  }
}
