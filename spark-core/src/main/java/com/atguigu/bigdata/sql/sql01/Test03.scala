package com.atguigu.bigdata.sql.sql01

import org.apache.spark.SparkConf
import org.apache.spark.sql.types.{StructField, StructType}
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}

object Test03 {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")
    val spark = SparkSession.builder().config(conf).getOrCreate()

    //For implicit convertions like converting rdds to dataframe
    import spark.implicits._

//    val rdd = spark.sparkContext.makeRDD(List(1,2,3,4))
//
//    val df = rdd.toDF()

    //    val df2 = spark.read.json("spark-core/datas/1.json")
    //
    //    //print schema in a tree format
    //    df2.printSchema()
    //
    //    df2.show()
    //    //select only the "name" column
    //    df2.select("name").show()
    //    //select name and age , but increment the age by 1
    //    df2.select($"name",$"age"+1).show()
    //    //judge whether age older than 30 or not
    //    df2.select($"age">30).show()
    //    //filter age older than 30 years
    //    df2.filter($"age">30).show()
    //    //group by age , calc and display num
    //    df2.groupBy("age").count().show()
    //
    //    df2.createOrReplaceTempView("User")
    //
    //    val sqlDF = spark.sql("select * from user")
    //
    //    sqlDF.show()
    //
    //    println("===================================")
    //
    //    //register the dateframe as a global temporary view
    //    df2.createGlobalTempView("people")
    //    //global temporary view is tied to a system preserved database 'global_temp'
    //    spark.sql("select * from global_temp.people").show()
    //
    //    spark.newSession().sql("select name from global_temp.people").show()
    //
    //    println("====================")
    //
    //    val persons: Seq[Person] = Seq(Person("zhangsan",10))
    //    persons.toDS().show()


    //collect can translate to dataset e.g / seq( 1,2,3 )  => Dataset[Int]
//    val value: Dataset[Int] = Seq(1,2,3).toDS()
//    val value1: Dataset[Person] = Seq(Person("zhangsan",10)).toDS()

//    val dataset1: Dataset[(Int, Int)] = value.map((_,1))
//    val arr: Array[(Int, Int)] = dataset1.collect()
//    arr.foreach(println)

    val frame: DataFrame = spark.read.json("spark-core/datas/1.json")

    frame.printSchema()

    val ds1: Dataset[Person] = frame.as[Person]

    ds1.show()

    spark.stop()

  }
  case class Person(name:String)
}
