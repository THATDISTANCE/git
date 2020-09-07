package com.atguigu.bigdata.spark.spark12

import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD

object Test01 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("applicatoin")

    val spark = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._
    val value = spark.sparkContext.textFile("spark-core/datas/1.json")

    val rdd: RDD[Int] = spark.sparkContext.parallelize(List(1,2,3,4))




    spark.stop()
  }

  case class User(
                 var id : Int,
                 var name : String,
                 var age : Int
                 )

}
