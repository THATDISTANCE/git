package com.atguigu.bigdata.spark.spark07

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test12 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("sc")
    val sc = new SparkContext(conf)

    val lineRdd : RDD[String] = sc.textFile("spark-core/datas/agent.log")

    val tapRdd : RDD[((String,String),Int)]= lineRdd.map(
      line=>{
        val str = line.split(" ")
        ((str(1),str(4)),1)
      }
    )

    val redRdd : RDD[((String,String),Int)] = tapRdd.reduceByKey(_+_)

    val areRdd = redRdd.map {
      case ((a, b), c) => (a, (b, c))
    }

    val groupRdd = areRdd.groupByKey()

//    val resuleRdd : RDD[(String,List[(String,Int)])] = groupRdd.map{
//      case (province,adandnum) =>{
//        val sortRdd = adandnum.toList.sortWith((a,b)=>a._2 > b._2)
//        val taRdd = sortRdd.take(3)
//        (province,taRdd)
//      }
//    }

//    val resuleRdd = groupRdd.sortBy {
//      case (a, b) => (b.toList.sorted.reverse,false)
//    }


    sc.stop()
  }
}
