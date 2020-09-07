package com.atguigu.bigdata.spark.spark06

import org.apache.spark.rdd.RDD
import org.apache.spark.{HashPartitioner, Partitioner, SparkConf, SparkContext}

object Test12 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    val rdd1 : RDD[Int] = sc.makeRDD(List(1,2,3,4),2)
    val rdd2 : RDD[(Int,Int)]= rdd1.map((_,1))

    val v1 : RDD[(Int,Int)] = rdd2.partitionBy(new MyPartitioner(3))

    v1.saveAsTextFile("spark-core/out")
  }
}

class MyPartitioner(var num : Int) extends Partitioner{
  override def numPartitions: Int = num

  override def getPartition(key: Any): Int = {
    key match {
      case 1 => 0
      case 2 => 1
      case 3 => 2
      case 4 => 1
    }
  }
}
