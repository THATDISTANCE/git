package com.atguigu.bigdata.sql.sql04

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.receiver.Receiver

object Test07 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")
    val ssc = new StreamingContext(conf,Seconds(3))

    val ds = ssc.receiverStream(new CustomerReceiver(2*1000))

    ds.print()

    ssc.start()
    ssc.awaitTermination()
  }

  class CustomerReceiver(sleepTime:Long) extends Receiver[String](StorageLevel.MEMORY_ONLY){

    private var flag = true

    override def onStart(): Unit = {
      while ( true ){

        val s = "customer receiver : "+System.currentTimeMillis()

        store(s)

        Thread.sleep(sleepTime)

      }
    }

    override def onStop(): Unit = {
      flag = false
    }

  }

}
