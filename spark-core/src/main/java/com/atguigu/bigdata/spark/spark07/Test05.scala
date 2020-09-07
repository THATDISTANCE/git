package com.atguigu.bigdata.spark.spark07

import org.apache.spark.{SparkConf, SparkContext}

object Test05 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    // TODO KV类型的数据操作
    val rdd = sc.makeRDD(
      List(("a", 88), ("b", 95), ("a", 91), ("b", 93), ("a", 95), ("b", 98))
    )

//    rdd.combineByKey(
//      x=> (x,1),
//      (x:(Int,Int),y:Int)=>(x._1+y,x._2+1),
//      (x:(Int,Int),y:(Int,Int))=>(x._1+y._1,x._2,y._2)
//    )

    rdd.combineByKey(
      x => (x, 1),
      (x:(Int,Int), y:Int) => ( x._1 + y, x._2 + 1 ),
      (x:(Int,Int), y:(Int,Int)) => ( x._1 + y._1, x._2 + y._2 )
    ).collect.foreach(println)


    sc.stop()

  }
}
