package com.atguigu.bigdata.sql.sql05

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Test08 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")
    val ssc = new StreamingContext(conf,Seconds(3))

    val funUpdate = (values : Seq[Int] , state : Option[Int])=>{
      Some(values.foldLeft(state.getOrElse(0))(_+_))
    }

    ssc.checkpoint("spark-core/checkpoint")

    val lineDS = ssc.socketTextStream("localhost",9999)

    val wordDS = lineDS.flatMap(_.split(" "))

    val mapDS = wordDS.map((_,1))

    mapDS.updateStateByKey[Int](funUpdate).print()

    ssc.start()
    ssc.awaitTermination()

  }
}
