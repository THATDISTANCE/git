package com.atguigu.bigdata.spark.spark10

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test05 {
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

    val traRdd: RDD[(String, Int)] = value1.reduceByKey(
      (a, b) => (a._1, a._2 + b._2)
    ).map {
      case (a, (b, c)) => (b, c)
    }

    val traRdd2: RDD[(String, (Int, Int, Int))] = value.reduceByKey {
      case ((a, b, c), (a1, b1, c1)) => {
        (a + a1, b + b1, c + c1)
      }
    }

//    val traRdd2: Array[(String, (Int, Int, Int))] = redRdd2 sortBy(_._2,false)take(10)


    val joinRDD: RDD[(String, ((Int, Int, Int), Int))] = traRdd2.join(traRdd)

    val resultRdd = joinRDD.map {
      case (a, ((b, c, d), e)) => {
        (a, (b, c, d, e))
      }
    }

    val tmpRdd = resultRdd.groupByKey().sortBy(_._2,false).take(10)

    val realResultRdd: Array[(String, List[(Int, Int, Int, Int)])] = tmpRdd.map {
      case (a, b) => {
        (a, b.toList.sorted.reverse.take(10))
      }
    }
    realResultRdd.foreach(println)

    sc.stop()


  }
}
