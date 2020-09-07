package com.atguigu.bigdata.spark.framework.service

import com.atguigu.bigdata.spark.framework.dao.EquipmentDAO
import org.apache.spark.rdd.RDD

class EquipmentService extends TService {

  private val dao = new EquipmentDAO


  override def analysis(data: Any) : RDD[(Long, List[(String, Int)])] = {

    val top10tmp = data.asInstanceOf[Array[(String,(Int,Int,Int))]]

    val top10 = top10tmp.map(_._1)

    val actionRdd = dao.readFile("spark-core/datas/user_visit_action.txt")

    val actionobjRdd = actionRdd.map {
      action => {
        val datas = action.split("_")
        PackageUtil(
          datas(0),
          datas(1).toLong,
          datas(2),
          datas(3).toLong,
          datas(4),
          datas(5),
          datas(6).toLong,
          datas(7).toLong,
          datas(8),
          datas(9),
          datas(10),
          datas(11),
          datas(12).toLong
        )
      }
    }

    val filRdd = actionobjRdd.filter(
      action => {
        top10.contains(action.click_category_id.toString)
      }
    )

    val mapRdd = filRdd.map(
      action => {
        ((action.click_category_id, action.session_id), 1)
      }
    )

    val reuRdd = mapRdd.reduceByKey(_+_)

    val mapRdd2 = reuRdd.map {
      case ((id, session), sum) => {
        (id, (session, sum))
      }
    }

    val groupRdd = mapRdd2.groupByKey()

    val valueRdd = groupRdd.mapValues(
      x => {
        x.toList.sortWith(
          (x, y) => {
            x._2 > y._2
          }
        ).take(10)
      }
    )
    valueRdd
  }

  override def analysis(): Unit = {}

}
