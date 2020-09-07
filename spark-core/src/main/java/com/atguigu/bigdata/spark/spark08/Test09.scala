package com.atguigu.bigdata.spark.spark08

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test09 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)

    val lineRdd = sc.textFile("spark-core/datas/1.txt")
    val wordRdd = lineRdd.flatMap(_.split(" "))
    //1. TODO groupBy
//    val groupRdd = wordRdd.groupBy(word=>word)
//    val mapRdd = groupRdd.map {
//      case (word, iter) => {
//        (word, iter.size)
//      }
//    }
//    mapRdd.foreach(println)
    //2. TODO groupByKey
//    val mapRdd = wordRdd.map((_,1))
//    val groupRdd = mapRdd.groupByKey()
//    val mapRdd2 = groupRdd.map {
//      case (word, iter) => {
//        (word, iter.sum)
//      }
//    }
//    mapRdd2.foreach(println)

    //3. TODO reduceByKey
//    val mapRdd = wordRdd.map((_,1))
//    val redRdd = mapRdd.reduceByKey(_+_)
//    redRdd.foreach(println)

    //4. TODO aggregateByKey
//    val mapRdd = wordRdd.map((_,1))
//    val aggRdd = mapRdd.aggregateByKey(0)(_+_,_+_)
//    aggRdd.foreach(println)

    //5. TODO foldByKey
//    val mapRdd = wordRdd.map((_,1))
//    val aggRdd = mapRdd.foldByKey(0)(_+_)
//    aggRdd.foreach(println)

    //6. TODO combineByKey
//    val mapRdd = wordRdd.map((_,1))
//    val comRdd = mapRdd.combineByKey(
//      x => x,
//      (x: Int, y: Int) => x + y,
//      (x: Int, y: Int) => x + y
//    )
//    comRdd.foreach(println)

    //7. TODO countByKey
//    val mapRdd = wordRdd.map((_,3))
//    val countRd: collection.Map[String, Long] = mapRdd.countByKey()
//    println(countRd)

    // 8. TODO countByValue
//       println(wordRdd.countByValue())

    // 9. TODO aggregate
//    val mapRdd = wordRdd.map((_,1))
//    val aggRdd = mapRdd.aggregate(Map[String, Int]())(
//      (map1, kv) => {
    ////        val k = kv._1
    ////        val v = kv._2
    ////        map1.updated(k, map1.getOrElse(k, 0) + v)
    ////      },
//      (map1, map2) => {
//        map1.foldLeft(map2)(
//
//          (map1, kv) => {
//            val k = kv._1
//            val v = kv._2
//            map1.updated(k, map1.getOrElse(k, 0) + v)
//          }
//
//        )
//      }
//    )
//    println(aggRdd)

    // 10. TODO fold
//    val mapRdd = wordRdd.map((_,1))
//    val mapRdd2 = mapRdd.map(kv=>Map[String,Int](kv))
//    val aggRdd = mapRdd2.fold(Map[String, Int]())(
//      (map1, map2) => {
//        map1.foldLeft(map2)(
//
//          (map1, kv) => {
//            val k = kv._1
//            val v = kv._2
//            map1.updated(k, map1.getOrElse(k, 0) + v)
//          }
//
//        )
//      }
//    )
//    println(aggRdd)

    // 11. TODO reduce
    val mapRdd = wordRdd.map((_,1))
//    val mapRdd2 = mapRdd.map(kv=>Map[String,Int](kv))

    val mapRdd2 = mapRdd.map(kv=>Map[String,Int](kv))

    val redRdd = mapRdd2.reduce(
      (map1, map2) => {
        map1.foldLeft(map2)(

          (map1, kv) => {
            val k = kv._1
            val v = kv._2
            map1.updated(k, map1.getOrElse(k, 0) + v)
          }

        )
      }
    )
    println(redRdd)

    sc.stop()

  }
}
