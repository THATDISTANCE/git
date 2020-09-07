package com.atguigu.bigdata.spark.spark08

import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}

object Test10 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("exe")
    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(List(1,2,3,4,5,6))

    val acc = new MyAcc
    sc.register(acc,"acc")

    rdd.foreach(
      x=>{
        acc.add(x)
      }
    )

    val value = acc.value
    println(value._1/value._2)

    sc.stop()
  }

  class MyAcc extends AccumulatorV2[Int,(Int,Int)]{

    private var tup = (0,0)

    override def isZero: Boolean = tup._1 == 0 && tup._2 == 0

    override def copy(): AccumulatorV2[Int, (Int,Int)] = new MyAcc

    override def reset(): Unit = tup = (0,0)

    override def add(v: Int): Unit = {
      tup = (tup._1 + v,tup._2+1)
    }

    override def merge(other: AccumulatorV2[Int, (Int,Int)]): Unit = {
      val value1 = other.value
      tup = (tup._1+value1._1,tup._2+value1._2)
    }

    override def value: (Int,Int) = tup
  }

}
