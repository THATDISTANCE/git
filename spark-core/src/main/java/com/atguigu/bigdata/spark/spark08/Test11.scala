package com.atguigu.bigdata.spark.spark08

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test11 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("exe")
    val sc = new SparkContext(conf)

    val lineRdd = sc.textFile("spark-core/datas/1.txt")

    val wordRdd = lineRdd.flatMap(_.split(" "))

    val mapRdd : RDD[(String,Int)] = wordRdd.map((_,1))

//    val aggRDD = mapRdd.aggregate(Map[String, Int]())(
//      (u, kv) => {
//        u.updated(kv._1, u.getOrElse(kv._1, 0) + kv._2)
//      },
//      (map1, map2) => {
//        map1.foldLeft(map2)(
//          (map2, kv) => {
//            val k = kv._1
//            val v = kv._2
//            map2.updated(k, map2.getOrElse(k, 0) + v)
//          }
//        )
//      }
//    )
//
//    aggRDD.toList.sortBy(_._2).foreach(println)

//    val map = mapRdd.map(
//      kv => Map[String, Int](kv)
//    )
//
//    val foldRdd = map.fold(Map[String, Int]())(
//      (left, right) => {
//        left.foldLeft(right)(
//          (right, kv) => {
//            val k = kv._1
//            val v = kv._2
//            right.updated(k, right.getOrElse(k, 0) + v)
//          }
//        )
//      }
//    )
//
//    for (elem <- foldRdd) {
//      println(elem)
//    }


    val map = mapRdd.map(
      x => {
        Map[String, Int](x)
      }
    )

    val redRdd = map.reduce(
      (map1, map2) => {
        map1.foldLeft(map2)(
          (map2, kv) => {
            val k = kv._1
            val v = kv._2
            map2.updated(k, map2.getOrElse(k, 0) + v)
          }
        )
      }
    )

    redRdd.foreach(println)

    sc.stop()
  }
}
