package com.atguigu.bigdata.sql.sql05

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.{Minutes, Seconds, StreamingContext}

object Test06 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")
    val ssc = new StreamingContext(conf,Seconds(3))

    ssc.remember(Minutes(5))

    val lineDS = ssc.socketTextStream("localhost",9999)

    val wordDS = lineDS.flatMap(x=>x.split(" "))

    wordDS.foreachRDD(
      rdd=>{
        val spark = SparkSession.builder().config(conf).getOrCreate()
        import spark.implicits._

        val df = rdd.toDF("word")

        df.createOrReplaceTempView("user")

        spark.sql("select word , count(*) from user group by word").show()
      }
    )

    ssc.start()
    ssc.awaitTermination()
  }
}
