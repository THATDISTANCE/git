package com.atguigu.bigdata.spark.spark09

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test06 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("sc")
    val sc = new SparkContext(conf)

    val actionRdd = sc.textFile("spark-core/datas/user_visit_action.txt")

    val filRdd = actionRdd.filter(
      x => {
        val datas = x.split("_")
        datas(6) != "-1"
      }
    )

    val clickRDD = filRdd.map(
      x => {
        val datas = x.split("_")
        (datas(6), 1)
      }
    )
    
    val totalClickRDD = clickRDD.reduceByKey(_+_)

    println("================================")

    val orderRDD = actionRdd.filter(
      x => {
        val datas = x.split("_")
        datas(8) != "-1"
      }
    )

    val totalOrderRDD = orderRDD.flatMap(
      x => {
        val datas = x.split("_")
        val str = datas(8).split(",")
        str.map((_, 1))
      }
    )

    val totalRdd = totalOrderRDD.reduceByKey(_+_)

    println("================================")

    val payRDD = actionRdd.filter(
      x => {
        val datas = x.split("_")
        datas(10) != "-1"
      }
    )

    val totalPayRDD = orderRDD.flatMap(
      x => {
        val datas = x.split("_")
        val str = datas(10).split(",")
        str.map((_, 1))
      }
    )

    val totalRdd2 = totalPayRDD.reduceByKey(_+_)

    println("=================================")

    val rdd1 = totalClickRDD.leftOuterJoin(totalRdd)
    val rdd2: RDD[(String, ((Int, Option[Int]), Option[Int]))] = rdd1.leftOuterJoin(totalRdd2)

    val resultRdd = rdd2.map {
      case (key, ((click, order), pay)) => {
        //        (key,(click,order,pay))

        val order1 = order.getOrElse(0)
        val pay1 = pay.getOrElse(0)

        (key, (click, order1, pay1))

      }
    }

    val tuples: Array[(String, (Int, Int, Int))] = resultRdd.sortBy(_._2, false).take(10)


    for (elem <- tuples) {
      println(elem)
    }

    sc.stop()
  }
}
