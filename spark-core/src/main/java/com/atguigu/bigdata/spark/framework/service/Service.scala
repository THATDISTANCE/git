package com.atguigu.bigdata.spark.framework.service

import com.atguigu.bigdata.spark.framework.dao.DAO
import org.apache.spark.rdd.RDD

class Service extends TService {

  private val dao = new DAO

  def execute():Array[(String,(Int,Int,Int))] = {

    val actionRdd = dao.readFile("spark-core/datas/user_visit_action.txt")

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

    resultRdd.sortBy(_._2,false).take(10)

  }

  override def analysis(data: Any): RDD[(Long, List[(String, Int)])] = {
    return null
  }
}

