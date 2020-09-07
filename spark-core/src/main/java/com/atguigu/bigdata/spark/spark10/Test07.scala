package com.atguigu.bigdata.spark.spark10

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test07 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("app2")
    val sc = new SparkContext(conf)

    val actionRdd = sc.textFile("spark-core/datas/user_visit_action.txt")

    val value: RDD[(String, (Int, Int, Int))] = actionRdd.flatMap(
      x => {
        val datas = x.split("_")
        if (datas(6) != "-1") {
          List((datas(6), (1, 0, 0)))
        } else if (datas(8) != "null") {
          val sp1 = datas(8).split(",")
          sp1.map((_, (0, 1, 0)))

        } else if (datas(10) != "null") {
          val sp2 = datas(10).split(",")
          sp2.map((_, (0, 0, 1)))
        } else {
          Nil
        }
      }
    )

    val value1: RDD[(String,(String,Int))] = actionRdd.flatMap(
      x => {
        val datas = x.split("_")
        List((datas(2),(datas(6), 1)))
      }
    )

    val traRdd: RDD[(String,(String,Int))] = value1.reduceByKey(
      (a, b) => (a._1, a._2 + b._2)
    ).map {
      case (a, (b, c)) => (b, (a, c))
    }

    val traRdd2: RDD[(String, (Int, Int, Int))] = value.reduceByKey {
      case ((a, b, c), (a1, b1, c1)) => {
        (a + a1, b + b1, c + c1)
      }
    }

    val joinRDD: RDD[(String, ((Int, Int, Int), (String, Int)))] = traRdd2.join(traRdd)

    val tmpRdd = joinRDD.groupByKey().sortBy(_._2,false).take(10)

    val result: Array[(String, List[((Int, Int, Int), (String, Int))])] = tmpRdd.map {
      case (a, b) => {
        (a, b.toList.sortBy(_._2._2).takeRight(10).reverse)
      }
    }

    val realResult: Array[(String, List[(Int, Int, Int)], List[(String, Int)])] = result.map {
      case (a, b) => {
        (a, b.map(_._1).distinct, b.map(_._2))
      }
    }
    realResult.foreach(println)
    sc.stop()
  }
}
