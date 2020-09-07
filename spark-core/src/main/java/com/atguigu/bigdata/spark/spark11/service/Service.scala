package com.atguigu.bigdata.spark.spark11.service

import com.atguigu.bigdata.spark.spark11.common.Tservice
import com.atguigu.bigdata.spark.spark11.dao.DAO
import org.apache.spark.rdd.RDD
import org.apache.spark.util.AccumulatorV2

import scala.collection.mutable

class Service extends Tservice {

  private val dao = new DAO

  override def process() = {

    val sc: RDD[String] = dao.read("spark-core/datas/user_visit_action.txt")

    val acc = new Acc

    dao.register(acc)

    val elem = sc.filter(_.split("_")(6) != "-1").map(_.split("_")(6))
    elem.map(x => acc.add(x, "click"))

    val arr = sc.filter(_.split("_")(8) != "null").flatMap(_.split("_")(8).split(","))
    arr.foreach(x => acc.add(x, "order"))

    val arr1 = sc.filter(_.split("_")(10) != "null").flatMap(_.split("_")(10).split(","))
    arr1.foreach(x => acc.add(x, "pay"))

    val tuples: List[(String, HotCategory)] = acc.value.toList.sortWith {
      case (a, b) => {
        if (a._2.clickCount > b._2.clickCount) {
          true
        } else if (a._2.clickCount == b._2.clickCount) {
          if (a._2.orderCount > b._2.orderCount) {
            true
          } else if (a._2.orderCount == b._2.orderCount) {
            a._2.payCount > b._2.payCount
          } else {
            false
          }
        } else {
          false
        }
      }
    }
    tuples.foreach(println)


  }
}
class Acc extends AccumulatorV2[(String,String),mutable.Map[String,HotCategory]]{

  val category = mutable.Map[String,HotCategory]()

  override def isZero: Boolean = category.isEmpty

  override def copy(): AccumulatorV2[(String, String), mutable.Map[String, HotCategory]] = new Acc

  override def reset(): Unit = category.clear()

  override def add(v: (String, String)): Unit = {
    val id = v._1
    val ptype = v._2
    val cate = category.getOrElse(id,HotCategory(id,0,0,0))

    ptype match {
      case "click" => cate.clickCount += 1
      case "order" => cate.orderCount += 1
      case "pay" => cate.payCount += 1
    }
    category.update(id,cate)
  }

  override def merge(other: AccumulatorV2[(String, String), mutable.Map[String, HotCategory]]): Unit = {
    other.value.foreach{
      case (id , otherHc)=>{
        val cate = category.getOrElse(id,HotCategory(id,0,0,0))
        cate.clickCount += otherHc.clickCount
        cate.orderCount += otherHc.orderCount
        cate.payCount += otherHc.payCount
        category.update(id,cate)
      }
    }
  }

  override def value: mutable.Map[String, HotCategory] = category
}

case class HotCategory(
                        var id : String,
                        var clickCount : Int,
                        var orderCount : Int,
                        var payCount : Int
                      )