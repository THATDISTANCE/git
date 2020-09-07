package com.atguigu.bigdata.sql.sql01

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

object Test04 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")
    val spark = SparkSession.builder().config(conf).getOrCreate()

    import spark.implicits._

    val df1: DataFrame = spark.read.json("spark-core/datas/1.json")

    df1.createOrReplaceTempView("user")

    spark.udf.register("addName",(x:String)=>"Name:"+x)

    spark.sql("select addName(name) , id , age from user").show()

    val rdd: RDD[Row] = df1.rdd

    rdd.foreach(println)

    val mapRdd = rdd.map(x=>(x.getLong(0),1))

    val tuple: (Long, Int) = mapRdd.reduce(
      (x, y) => {
        (x._1 + y._1, x._2 + y._2)
      }
    )

    val result = tuple._1.toDouble / tuple._2

    println(result)

    spark.stop()
  }
}
