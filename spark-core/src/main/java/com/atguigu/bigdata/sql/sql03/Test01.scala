package com.atguigu.bigdata.sql.sql03

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object Test01 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")
    val spark = SparkSession.builder().config(conf).getOrCreate()

//    val df = spark.read.load("spark-core/datas/users.parquet")

//    spark.sql("select * from parquet.`spark-core/datas/users.parquet`").show()

//    df.write.format("json").mode("append")save("spark-core/datas/users")
////    df.write.format("json").mode("overwrite").save("spark-core/datas/users")
//    df.write.format("json").mode("error").save("spark-core/datas/users")
////    df.write.format("json").mode("append").save("spark-core/datas/users")
////    df.write.format("json").mode("ignore").save("spark-core/datas/users")

//    val df = spark.read.format("csv")
//      .option("sep",";")
//      .option("header",true)
//      .load("spark-core/datas/people.csv")
//
//    df.show()


    spark.stop()
  }
}
