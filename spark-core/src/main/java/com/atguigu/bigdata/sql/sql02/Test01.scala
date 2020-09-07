package com.atguigu.bigdata.sql.sql02

import org.apache.spark.SparkConf
import org.apache.spark.sql.{Dataset, Encoder, Encoders, SparkSession, TypedColumn, functions}
import org.apache.spark.sql.expressions.Aggregator

object Test01 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")
    val spark = SparkSession.builder().config(conf).getOrCreate()

    import spark.implicits._
    val df = spark.read.json("spark-core/datas/1.json")

//    df.createOrReplaceTempView("user")
//
//    val agg = new Agg
//
//    spark.udf.register("avgAge", functions.udaf(agg))
//
//    spark.sql("select avgAge(age) from user").show()

    val ds: Dataset[User] = df.as[User]
    val agg = new Agg

    val column: TypedColumn[User, Long] = agg.toColumn

    ds.select(column).show()



    spark.stop()
  }

  case class User(
                 var id : Long,
                 var name : String,
                 var age : Long
                 )
  case class AgeBuffer(
                      var sum:Long,
                      var count:Long
                      )

  class Agg extends Aggregator[User,AgeBuffer,Long]{

    override def zero: AgeBuffer = AgeBuffer(0,0)

    override def reduce(b: AgeBuffer, a: User): AgeBuffer = {
      b.sum += a.age
      b.count += 1
      b
    }

    override def merge(b1: AgeBuffer, b2: AgeBuffer): AgeBuffer = {
      b1.sum += b2.sum
      b1.count += b2.count
      b1
    }

    override def finish(reduction: AgeBuffer): Long = {
      reduction.sum.toLong / reduction.count
    }

    override def bufferEncoder: Encoder[AgeBuffer] = Encoders.product

    override def outputEncoder: Encoder[Long] = Encoders.scalaLong

  }

}
