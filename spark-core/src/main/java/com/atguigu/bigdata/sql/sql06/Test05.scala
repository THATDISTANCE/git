package com.atguigu.bigdata.sql.sql06

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Test05 {
  def main(args: Array[String]): Unit = {

    def functionToCreateStreamingContext():StreamingContext={
      val conf = new SparkConf().setMaster("local[*]").setAppName("app")
      val ssc = new StreamingContext(conf,Seconds(3))
      val lineSC: ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)
      val tupSC = lineSC.map((_,1))
      val upSC = tupSC.updateStateByKey[Int](functionToUpdate _)
      upSC.print()
      ssc.checkpoint("spark-core/output1")
      ssc
    }

    def functionToUpdate(newValues:Seq[Int],runningCount:Option[Int])={
      var tmp = 0
      for (elem <- newValues) {
        tmp += elem
      }
      val result = runningCount.getOrElse(0) + tmp
      Option(result)
    }

    val ssc = StreamingContext.getOrCreate("spark-core/output1",()=>functionToCreateStreamingContext())

    ssc.start()
    ssc.awaitTermination()
  }
}
