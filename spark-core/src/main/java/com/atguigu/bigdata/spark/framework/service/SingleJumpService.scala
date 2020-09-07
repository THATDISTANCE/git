package com.atguigu.bigdata.spark.framework.service

import com.atguigu.bigdata.spark.framework.dao.SingleJumpDAO
import org.apache.spark.rdd.RDD

class SingleJumpService extends TService {

  private val dao = new SingleJumpDAO

  override def analysis()= {

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

    actionobjRdd.cache()

    val mapRdd = actionobjRdd.map(
      action => {
        (action.page_id, 1)
      }
    )
    val sum = mapRdd.reduceByKey(_+_).collect()

    val mapSum = sum.toMap


    val groupRdd = actionobjRdd.groupBy(_.session_id)

    val sortRdd = groupRdd.mapValues(
      iter => {
        val map1 = iter.toList.sortWith(
          (left, right) => {
            left.action_time < right.action_time
          }
        ).map(_.page_id)
        val zipRdd = map1.zip(map1.tail)
        zipRdd.map{
          case (id1, id2)=>{
            ((id1,id2),1)
          }
        }
      }
    )

    val sortRdd2 = sortRdd.map(_._2)

    val flatRdd: RDD[((Long, Long), Int)] = sortRdd2.flatMap(x=>x)

    val reduRdd: RDD[((Long, Long), Int)] = flatRdd.reduceByKey(_+_)

    reduRdd.foreach{
      case ((id1,id2),sum)=>{
        var all = mapSum.getOrElse(id1,1)
        println(s"页面[$id1-$id2]单跳转化率="+sum.toDouble/all)
      }
    }

  }
}
