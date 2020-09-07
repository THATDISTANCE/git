package com.atguigu.bigdata.spark.spark06

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test06 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("test")
    val sc = new SparkContext(conf)

//    val rdd = sc.makeRDD(List(1,2,3,4))
//
//    val filRdd = rdd.filter(x=>x % 2 == 0)
//    filRdd.collect() foreach println

    val textRdd = sc.textFile("spark-core/datas/apache.log")
    val tupleRdd : RDD[(String,String)] = textRdd.map(x=>{

      val str = x.split(" ")
      (str(3),str(6))

    })

    val filRdd : RDD[(String,String)] = tupleRdd.filter{
      case (a,b)=> a.startsWith("17/05/2015")
    }

    filRdd.collect() foreach println

    sc.stop()
  }
}
