package com.atguigu.bigdata.sql.sql03

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Dataset, SparkSession}

object Test02 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")
    val spark = SparkSession.builder().config(conf).getOrCreate()

//    spark.read.format("jdbc")
//        .option("url","jdbc:mysql://localhost:3306/test")
//        .option("user","root")
//        .option("password","root")
//        .option("dbtable","t")
//        .load().show()

    val rdd : RDD[User]= spark.sparkContext.makeRDD(List(User(3,"王五"),User(4,"赵六")))

    import spark.implicits._

    val ds: Dataset[User] = rdd.toDS()

    ds.write.format("jdbc")
      .option("url","jdbc:mysql://localhost:3306/test")
        .option("user","root")
        .option("password","root")
        .option("dbtable","t")
        .mode("append")
        .save()


    spark.stop()
  }

  case class User(val id :Int,val name : String)
}
