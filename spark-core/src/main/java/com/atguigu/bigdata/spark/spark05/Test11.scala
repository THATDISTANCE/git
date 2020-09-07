package com.atguigu.bigdata.spark.spark05

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test11 {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

//    val rdd = sc.makeRDD(List(1,2,3,4,5,6),2)
//    val parRdd : RDD[(Int,Int)] = rdd.mapPartitionsWithIndex(
//      (index,datas)=>{datas.map((index,_))}
//    )
//    parRdd.collect() foreach println


    //    val parRdd : RDD[(Int,(Int,Int))]= rdd.mapPartitionsWithIndex(
    //      (index,datas)=>{
    //        datas.map((index,_)).map(
    //          if(index == 1){
    //            (index,_)
    //          }else{
    //            (index,_)
    //          }
    //        )
    //
    //      }
    //    )


    val rdd = sc.makeRDD(List(1,2,3,4,5,6),2)

    var parRdd = rdd.mapPartitionsWithIndex(
      (index,datas)=>{
        if(index ==1){
          datas
        }else{
          Nil.iterator
        }
      }
    )


    parRdd.collect() foreach println


    sc.stop()
  }
}
