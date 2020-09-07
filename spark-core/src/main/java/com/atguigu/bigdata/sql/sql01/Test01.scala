package com.atguigu.bigdata.sql.sql01

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object Test01 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("sql")

    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()

    import spark.implicits._

    val dataFrame = spark.read.json("spark-core/datas/1.json")

    spark.udf.register("addName",(x:String)=>"Name:"+x)

    dataFrame.createOrReplaceTempView("User")

    spark.sql("select addName(name),age from User").show()

//    val value = dataFrame.as[User]
//
//    value.show()

//    dataFrame.createOrReplaceTempView("user")
//    spark.sql("select * from user").show()

//    dataFrame.select("id","name").show()

//    val ds: Dataset[User] = dataFrame.as[User]
//
//    val frame: DataFrame = ds.toDF()

//    val rdd = spark.sparkContext.parallelize(List((1,"zhangsan",30),(2,"lisi",40),(3,"wangwu",50)))
//
//    val df1: DataFrame = rdd.toDF("id","name","age")
//
//    df1.show()
//
//    println("=======================")
//
//    val ds: Dataset[User] = df1.as[User]
//
//    ds.show()
//
//    println("=======================")
//
//    val df2 = ds.toDF()
//
//    df2.show()
//
//    println("========================")
//
//    val rdd1: RDD[Row] = df2.rdd
//
//    rdd1.foreach(x=>println(x.getString(1)))
//
//    println("==========================")

    //    rdd1.map{
    //      case (id,name,age)=>{
    //        User(id,name,age)
    //      }
    //    }
//        val ds3: Dataset[User] = rdd.map {
//          case (a, b, c) => {
//            User(a, b, c)
//          }
//        }.toDS()
//
//    val rdd2: RDD[User] = ds3.rdd
//
//    rdd2.foreach(println)


    spark.stop()
  }

  case class User(
                 id:Long,
                 name:String,
                 age:Long
                 )
}
