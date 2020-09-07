package com.atguigu.bigdata.spark.spark10

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test02 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("sc")
    val sc = new SparkContext(conf)

    val actionRdd = sc.textFile("spark-core/datas/user_visit_action.txt")

    actionRdd.cache()

    val filRdd = actionRdd.filter(
      x => {
        val datas = x.split("_")
        datas(6) != "-1"
      }
    )
    val clickRdd = filRdd.map(
      x => {
        val datas = x.split("_")
        (datas(6), (1,0,0))
      }
    )

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
        clickId.map((_,(0,1,0)))
      }
    )

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
        payId.map((_,(0,0,1)))
      }
    )

    val thrTup: RDD[(String, (Int, Int, Int))] = clickRdd union orderRdd union payRdd
    val redRdd = thrTup.reduceByKey((a,b)=>(a._1+b._1,a._2+b._2,a._3+b._3)).sortBy(_._2,false).take(10)
    redRdd.foreach(println)


    sc.stop()


  }
}
