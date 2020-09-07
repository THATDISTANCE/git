package com.atguigu.bigdata.sql.sql04

import org.apache.spark.SparkConf
import org.apache.spark.sql.{Encoder, Encoders, SparkSession, functions}
import org.apache.spark.sql.expressions.Aggregator

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Test10 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")

    val spark = SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()

    spark.sql("use sgg200421").show()

    spark.udf.register("fun",functions.udaf(new Remark))

    spark.sql(
      """
        |select *
        |from
        |(select * ,
        |	rank() over(partition by `area` order by clickSum desc ) as rank
        |from
        |	(select `area` ,
        |			`product_name` ,
        |      count(click_product_id ) as clickSum ,
        |			 fun(city_name)  sssssssssssssssssssssssssssssssssssssss
        |	from
        |		(select *
        |		from `user_visit_action` u
        |		join `product_info` p on u.`click_product_id` = p.`product_id`
        |		join `city_info` c on u.`city_id` = c.`city_id`) t1
        |	group by `area` , `product_name`) t2 ) t3
        |where rank < 4
        |""".stripMargin).show()

    spark.stop()
  }

  case class Buff(
                 var cnt : Long ,
                 var cityMap : mutable.Map[String,Int]
                 )

  class Remark extends Aggregator[String,Buff,String]{

    override def zero: Buff = {
      Buff(0,mutable.Map[String,Int]())
    }

    override def reduce(b: Buff, a: String): Buff = {
      b.cnt += 1
      val newCount = b.cityMap.getOrElse(a,0) + 1
      b.cityMap.update(a,newCount)
      b
    }

    override def merge(b1: Buff, b2: Buff): Buff = {
      b2.cnt += b1.cnt
      b1.cityMap.foldLeft(b2.cityMap)(
        ( b2Map , kv ) =>{
          val newCount = b2Map.getOrElse(kv._1,0) + kv._2
          b2Map.update(kv._1,newCount)
          b2Map
        }
      )
      b2
    }

    override def finish(reduction: Buff): String = {
      val sum = reduction.cnt
      val map = reduction.cityMap
      val list = ListBuffer[String]()
      val preTwo = map.toList.sortBy(_._2).reverse.take(2)

      val hasOtherElem = map.size > 2

      var count = 0l

      preTwo.foreach{
        case (name , cnt)=>{
          val rate = cnt * 100 / sum
          list.append(name + " " + rate + "%")
          count += rate
        }
      }

      if(hasOtherElem){
        list.append("其他地区"+ " " + ( 1 - count ) + "%")
      }

      list.mkString(",")

    }

    override def bufferEncoder: Encoder[Buff] = Encoders.product

    override def outputEncoder: Encoder[String] = Encoders.STRING
  }
}
