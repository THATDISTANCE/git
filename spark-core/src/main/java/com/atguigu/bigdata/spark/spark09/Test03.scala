package com.atguigu.bigdata.spark.spark09

import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}

object Test03 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("exe")
    val sc = new SparkContext(conf)



    val rdd = sc.makeRDD(List(1,2,3,4),2)

    val acc = new MyAccumulator()
    sc.register(acc,"acc")

    val fRdd = rdd.foreach(
      x => {
        acc.add(x)
      }
    )

    println(acc.value)




    sc.stop()
  }

  class MyAccumulator extends AccumulatorV2[Int, Int] {

    private var temp = 0

    override def isZero: Boolean = temp == 0

    override def copy(): AccumulatorV2[Int, Int] = new MyAccumulator

    override def reset(): Unit = {
      temp = 0
    }

    override def add(v: Int): Unit = temp += v

    override def merge(other: AccumulatorV2[Int, Int]): Unit = temp += other.value

    override def value: Int = temp
  }
}
