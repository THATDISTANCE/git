package com.atguigu.bigdata.spark.spark10

import org.apache.spark.{SparkConf, SparkContext}

object Test03 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("sc")
    val sc = new SparkContext(conf)

    val actionRdd = sc.textFile("spark-core/datas/user_visit_action.txt")

    val mapRdd = actionRdd.flatMap(
      x => {
        val datas = x.split("_")
        if (datas(6) != "-1") {
          List((datas(6), (1, 0, 0)))
        } else if (datas(8) != "null") {
          val order = datas(8).split(",")
          order.map((_, (0, 1, 0)))
        } else if (datas(10) != "null") {
          val pay = datas(10).split(",")
          pay.map((_, (0, 0, 1)))
        } else {
          Nil
        }
      }
    )

    val resultRdd = mapRdd.reduceByKey{
      case ((a,b,c),(e,f,g))=>{
        (a+e,b+f,c+g)
      }
    }

    val top10 = resultRdd.sortBy(_._2,false).take(10)
    top10.foreach(println)


    sc.stop()


  }
}
