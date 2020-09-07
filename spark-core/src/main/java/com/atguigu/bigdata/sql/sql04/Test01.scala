package com.atguigu.bigdata.sql.sql04

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object Test01 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")

    val spark = SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()

    spark.sql("use sgg200421").show()

    spark.sql(
      """
        |CREATE TABLE `user_visit_action`(
        |  `date` string,
        |  `user_id` bigint,
        |  `session_id` string,
        |  `page_id` bigint,
        |  `action_time` string,
        |  `search_keyword` string,
        |  `click_category_id` bigint,
        |  `click_product_id` bigint,
        |  `order_category_ids` string,
        |  `order_product_ids` string,
        |  `pay_category_ids` string,
        |  `pay_product_ids` string,
        |  `city_id` bigint)
        |row format delimited fields terminated by '\t'
        """.stripMargin)

    spark.sql(
      """
        |load data local inpath 'spark-core/datas/user_visit_action.txt' into table sgg200421.user_visit_action
        |""".stripMargin)

    spark.sql(
      """
        |CREATE TABLE `product_info`(
        |  `product_id` bigint,
        |  `product_name` string,
        |  `extend_info` string)
        |row format delimited fields terminated by '\t'
        """.stripMargin)

    spark.sql(
      """
        |load data local inpath 'spark-core/datas/product_info.txt' into table product_info
        """.stripMargin)

    spark.sql(
      """
        |CREATE TABLE `city_info`(
        |  `city_id` bigint,
        |  `city_name` string,
        |  `area` string)
        |row format delimited fields terminated by '\t'
        """.stripMargin)

    spark.sql(
      """
        |load data local inpath 'spark-core/datas/city_info.txt' into table city_info
        """.stripMargin)



    spark.stop()
  }
}
