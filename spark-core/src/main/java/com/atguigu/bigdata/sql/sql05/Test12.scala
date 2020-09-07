package com.atguigu.bigdata.sql.sql05

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object Test12 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")
    val spark = SparkSession.builder().config(conf).getOrCreate()

    val df = spark.read.load("spark-core/datas/people.txt")
    df.show()

//    val lineRdd = spark.sparkContext.textFile("spark-core/datas/people.txt")
//
//    val flaRdd = lineRdd.map(_.split(" "))
//
//    val mapRdd = flaRdd.map(a=>Person(a(0),a(1).toLong))
//
//    val rdd: RDD[Person] = mapRdd
//
////    rdd.foreachPartition(x=>x.foreach(println))
//
//    import spark.implicits._
//
//    rdd.toDF().show()




    spark.stop()
  }

  case class Person(
                     name : String,
                     age : Long
                   )


}
