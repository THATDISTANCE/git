package com.atguigu.bigdata.spark.spark10

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test01 {
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
    val clickRdd = filRdd.map(
      x => {
        val datas = x.split("_")
        (datas(6), 1)
      }
    )
    val sumclick = clickRdd.reduceByKey(_+_)

    val filRdd2 = actionRdd.filter(
      x => {
        val datas = x.split("_")
        datas(8) != null
      }
    )
    val orderRdd = filRdd2.flatMap(
      x => {
        val datas = x.split("_")
        val clickId = datas(8).split(",")
        clickId.map((_,1))
      }
    )

    val sumOrder = orderRdd.reduceByKey(_+_)


    val filRdd3 = actionRdd.filter(
      x => {
        val datas = x.split("_")
        datas(10) != null
      }
    )

    val payRdd = filRdd3.flatMap(
      x => {
        val datas = x.split("_")
        val payId = datas(10).split(",")
        payId.map((_,1))
      }
    )
    val sumPay = payRdd.reduceByKey(_+_)

    val douMer: RDD[(String, (Int, Option[Int]))] = sumclick.leftOuterJoin(sumOrder)
    val thrMer: RDD[(String, ((Int, Option[Int]), Option[Int]))] = douMer.leftOuterJoin(sumPay)

    val newTup = thrMer.map {
      case (id, ((click, order), pay)) => {
        val order1 = order.getOrElse(0)
        val pay1 = pay.getOrElse(0)
        (id, (click, order1, pay1))
      }
    }
   val top10 = newTup.sortBy(_._2,false).take(10)
    top10.foreach(println)



    sc.stop()
  }
}
