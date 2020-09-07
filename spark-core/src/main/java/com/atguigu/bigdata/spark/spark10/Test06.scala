package com.atguigu.bigdata.spark.spark10

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test06 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("exe")
    val sc = new SparkContext(conf)

    val textRdd = sc.textFile("spark-core/datas/user_visit_action.txt")

    val flatRdd : RDD[(String,((Int,Int,Int),String))]= textRdd.flatMap(
      x => {
        val datas = x.split("_")
        if (datas(6) != "-1") {
          List((datas(6), ((1, 0, 0), datas(2))))
        } else if (datas(8) != "null") {
          val str = datas(8).split(",")
          str.map(
            x => {
              (x, ((0, 1, 0), datas(2)))
            }
          )
        } else if (datas(10) != "null") {
          val str1 = datas(10).split(",")
          str1.map(
            x => {
              (x, ((0, 0, 1), datas(2)))
            }
          )
        } else {
          Nil
        }
      }
    )

    flatRdd


    sc.stop()
  }
}
