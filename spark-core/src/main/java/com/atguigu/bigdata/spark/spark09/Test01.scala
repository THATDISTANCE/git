package com.atguigu.bigdata.spark.spark09

import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

object Test01 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("exe")
    val sc = new SparkContext(conf)
    sc.setCheckpointDir("spark-core/out")

    val rdd = sc.textFile("spark-core/datas/1.txt")

    val rdd2 = rdd.flatMap(
      x=>{
        println("=====4232==")
        x.split(" ")
      }
    )

//    rdd2.cache()
//    rdd2.persist(StorageLevel.MEMORY_ONLY)

    rdd2.checkpoint()

//    println("***********")
//
//    val v1 = rdd2.filter(x=>true)
//    println(v1.toDebugString)
//    v1.collect()
//
//    println("*************")

    val v2 = rdd2.map((_,1))

    v2.reduceByKey(_+_).collect() foreach println
    v2.reduceByKey(_+_).collect() foreach println





    sc.stop()

  }
}


//多个连续依赖，称之为血缘关系
//所谓的血缘关系，体现了业务执行的逻辑顺序


//所谓的依赖关系，两个RDD数据处理前后分区的关系
