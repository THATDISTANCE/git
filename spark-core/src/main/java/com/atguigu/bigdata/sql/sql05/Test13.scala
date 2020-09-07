package com.atguigu.bigdata.sql.sql05

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object Test13 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")
    val spark = SparkSession.builder().config(conf).getOrCreate()

//    val df = spark.read.load("spark-core/datas/users.parquet")
//
//    df.toDF().show()

//    val df = spark.read.format("csv")
//      .option("sep", " ")
//      .option("header", "true")
//      .option("inferSchema", "true")
//      .load("spark-core/datas/people.csv")
//
//    df.show()

    val df = spark.sql("select * from parquet.`spark-core/datas/users.parquet`")

    df.write
        .partitionBy("favorite_color")
        .option("path","spark-core/tmp")
        .bucketBy(42,"name")
        .saveAsTable("ttt")


    spark.stop()
  }
}
