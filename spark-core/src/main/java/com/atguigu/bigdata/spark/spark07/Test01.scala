package com.atguigu.bigdata.spark.spark07

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test01 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("hello")
    val sc = new SparkContext(conf)

    val textRdd = sc.textFile("spark-core/datas/agent.log")

    val tupleRdd : RDD[(String,String)] = textRdd.map(
      line=>{
        val str = line.split(" ")
        (str(1),str(4))
      }
    )

    val mapRdd : RDD[((String,String),Int)] = tupleRdd.map{
      case (pro,ad)=>{
        ((pro,ad),1)
      }
    }

    val redRdd : RDD[((String,String),Int)] = mapRdd.reduceByKey(_+_)

    val proRdd = redRdd.map {
      case ((pro,ad), sum) => (pro, (ad, sum))
    }

    val groupRdd = proRdd.groupByKey()

    val value = groupRdd.map {
      case (pro, iter) => {

        val tup = iter.toList.sortWith((a, b) => a._2 > b._2)
        val list = tup.take(3)

        (pro, list)
      }
    }
    value.collect() foreach println

    sc.stop()

  }

}
