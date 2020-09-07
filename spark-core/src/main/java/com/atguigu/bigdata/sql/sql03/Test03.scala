package com.atguigu.bigdata.sql.sql03

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object Test03 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")

    val spark = SparkSession.builder().enableHiveSupport().config(conf).getOrCreate()

//    spark.sql("show tables").show()

//    spark.sql("create table abc(id int)")
//    spark.sql("load data local inpath 'spark-core/datas/1.txt' into table abc")
//    spark.sql("select * from abc").show()

    spark.sql("show tables").show()

    spark.stop()
  }
}
