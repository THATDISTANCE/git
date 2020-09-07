package com.atguigu.bigdata.sql.sql06

import org.apache.spark.{SparkConf, TaskContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Test07 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")
    val ssc = new StreamingContext(conf,Seconds(3))

    val lineSC = ssc.socketTextStream("localhost",9999)

//
//    lineSC.foreachRDD { (rdd, time) =>
//      rdd.foreachPartition { partitionIterator =>
//
//        {
//          val partitionId = TaskContext.get.partitionId()
//          val uniqueId = generateUniqueId(time.milliseconds, partitionId)
//
//        }
//
//      }
//    }
//

    ssc.start()
    ssc.awaitTermination()
  }
}
