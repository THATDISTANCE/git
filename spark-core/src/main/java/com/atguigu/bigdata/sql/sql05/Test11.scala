package com.atguigu.bigdata.sql.sql05

import org.apache.spark.SparkConf
import org.apache.spark.sql.{Dataset, SparkSession}

object Test11 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")
    val spark = SparkSession.builder().config(conf).getOrCreate()

    import spark.implicits._

    val pDS = Seq(Person("zhangsan",20)).toDS()

    pDS.show()

    val iDS = Seq(1,2,3).toDS()

    iDS.collect() foreach(println)

    val df = spark.read.json("spark-core/datas/1.json")

    val ds: Dataset[Person] = df.as[Person]

    ds.show()

    spark.stop()
  }

  case class Person(
                   name : String,
                   age : Long
                   )

}
