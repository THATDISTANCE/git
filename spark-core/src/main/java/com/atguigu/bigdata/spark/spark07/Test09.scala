package com.atguigu.bigdata.spark.spark07

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test09 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)


    val rdd = sc.makeRDD(List(
      (new User(), 1), (new User(),2), (new User(), 3)
    ))

    println(Thread.currentThread().getName)

    val sortRdd : RDD[(User,Int)] = rdd.sortByKey(true)

    println(Thread.currentThread().getName)

    sortRdd.collect()foreach({
      println("inner     ============  "+Thread.currentThread().getName)
      println
    })

    sc.stop()

  }

  class User() extends Ordered[User]{
    override def compare(that: User): Int = -1
  }


}
