package com.atguigu.bigdata.sql.sql01

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object Test02 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("sql")

    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()

    import spark.implicits._

    val dataFrame = spark.read.json("spark-core/datas/1.json")

    spark.udf.register("addName",(x:String)=>"Name:"+x)

    dataFrame.createOrReplaceTempView("User")

    spark.sql("select addName(name),age from User").show()


  }

  case class User(id:Int,name:String,age:Int)

  case class User1(){
    var id : Int = _
    var name : String = _
    var age : Int = _
  }
}
