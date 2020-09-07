package com.atguigu.bigdata.spark.spark09

import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}

object Test05 {
  def main(args: Array[String]): Unit = {

    val exe = new SparkConf().setMaster("local").setAppName("exe")
    val sc = new SparkContext(exe)

    val rdd = sc.parallelize(List(1,2,3,4,5,6))

    val acc = new MyAcc()
    sc.register(acc,"sum")

    rdd.foreach(
      x=>{
        acc.add(x)
      }
    )

    println(acc.total / acc.count)


    sc.stop()
  }

  class MyAcc extends AccumulatorV2[Int,(Int,Int)]{

    var (total,count) = (0,0)

    override def isZero: Boolean = total == 0 && count == 0

    override def copy(): AccumulatorV2[Int, (Int, Int)] = new MyAcc

    override def reset(): Unit = {
      total = 0
      count = 0
    }

    override def add(v: Int): Unit = {
      total += v
      count += 1
    }

    override def merge(other: AccumulatorV2[Int, (Int, Int)]): Unit = {
      this.total += other.value._1
      this.count += other.value._2
    }

    override def value: (Int, Int) = (total,count)
  }
}
