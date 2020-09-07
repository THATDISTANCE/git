package com.atguigu.bigdata.spark.spark10

import org.apache.spark.rdd.RDD
import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

object Test04 {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("sc")
    val sc = new SparkContext(conf)

    val actionRdd = sc.textFile("spark-core/datas/user_visit_action.txt")

    var acc = new MyAcc

    sc.register(acc,"acc")

//        val mapRDD = actionRdd.foreach(
//          x => {
//            val datas = x.split("_")
//            if (datas(6) != "-1") {
//              acc.add( (datas(6), "click") )
//            } else if (datas(8) != "null") {
//              val ord = datas(8).split(",")
//              ord.foreach(
//                x => acc.add( (x, "order") )
//              )
//            } else if (datas(10) != "null") {
//              val pay = datas(10).split(",")
//              pay.foreach(
//                x => acc.add( (x, "pay") )
//              )
//            }
//          }
//        )

        val click: RDD[String] = actionRdd.filter(_.split("_")(6) != "-1").map(_.split("_")(6))
        click.foreach(elem => acc.add(elem,"click"))

    // 获得order
    val order: RDD[String] = actionRdd.filter(_.split("_")(8) != "null").flatMap(_.split("_")(8).split(","))
    order.foreach(elem => acc.add(elem,"order"))

    val pay: RDD[String] = actionRdd.filter(_.split("_")(10) != "null").flatMap(_.split("_")(10).split(","))
    pay.foreach(elem => acc.add(elem,"pay"))



    acc.value.map((_._2)).toList.sortWith{   //use type match in there is not useful , why ?
      (left , right )=>{
        if(left.clickCount > right.clickCount){
          true
        }else if(left.clickCount == right.clickCount){
          if(left.orderCount > right.orderCount){
            true
          }else if(left.orderCount == right.orderCount){
            left.payCount > right.payCount
          }else{
            false
          }
        }else{
          false
        }
      }
    }.take(10).foreach(println)



    sc.stop()


  }

//  class MyAcc extends AccumulatorV2[(String,String),mutable.Map[String,HotCategory]]{
//
//    val hotCategory = mutable.Map[String,HotCategory]()
//
//    override def isZero: Boolean = hotCategory.isEmpty
//
//    override def copy(): AccumulatorV2[(String, String), mutable.Map[String, HotCategory]] = new MyAcc
//
//    override def reset(): Unit = hotCategory.clear()
//
//    override def add(v: (String, String)): Unit = {
//      val id = v._1
//      val tType = v._2
//      val category = hotCategory.getOrElse(id,HotCategory(id,0,0,0))
//
//      tType match {
//        case "click"=> category.clickCount += 1
//        case "order"=> category.orderCount += 1
//        case "pay"=>   category.payCount += 1
//      }
//
//      hotCategory.update(id , category)
//
//    }
//
//    override def merge(other: AccumulatorV2[(String, String), mutable.Map[String, HotCategory]]): Unit = {
//
//      other.value.foreach{
//        case (id , otherHc) =>{
//          val thisHc = hotCategory.getOrElse(id , HotCategory(id,0,0,0))
//
//          thisHc.clickCount += otherHc.clickCount
//          thisHc.orderCount += otherHc.orderCount
//          thisHc.payCount += otherHc.payCount
//
//          hotCategory.update(id , thisHc)
//
//        }
//      }
//    }
//
//    override def value: mutable.Map[String, HotCategory] = hotCategory
//
//  }

  class MyAcc extends AccumulatorV2[(String,String),mutable.Map[String,HotCategory]]{

    var counter = mutable.Map[String,HotCategory]()

    override def isZero: Boolean = counter.isEmpty

    override def copy(): AccumulatorV2[(String, String), mutable.Map[String, HotCategory]] = new MyAcc

    override def reset(): Unit = counter.clear()

    override def add(v: (String, String)): Unit = {
      var id = v._1
      var ptype = v._2

      var category = counter.getOrElse(id , HotCategory(id , 0 , 0, 0))
      ptype match {
        case "click" => category.clickCount += 1
        case "order" => category.orderCount += 1
        case "pay"   => category.payCount += 1
      }

      counter.update(id , category)

    }

    override def merge(other: AccumulatorV2[(String, String), mutable.Map[String, HotCategory]]): Unit = {

      other.value.foreach{
        case (id , ho)=>{
          val category = counter.getOrElse(id , HotCategory(id , 0 ,0 ,0 ))
          category.clickCount += ho.clickCount
          category.orderCount += ho.orderCount
          category.payCount += ho.payCount
          counter.update(id,category)
        }
      }
    }

    override def value: mutable.Map[String, HotCategory] = counter
  }

  case class HotCategory(
    var id : String,
    var clickCount : Int,
    var orderCount : Int,
    var payCount : Int
  )


}
