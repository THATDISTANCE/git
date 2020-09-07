package com.atguigu.bigdata.sql.sql05

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Test02 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")
    val ssc = new StreamingContext(conf,Seconds(3))

    ssc.checkpoint("spark-core/checkpoint")

    val value: ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)

    val value1 = value.flatMap(_.split(" "))

    val mapDS = value1.map((_,1))

    val value2: DStream[(String, Int)] = mapDS.updateStateByKey[Int](
      (seq: Seq[Int], buffer: Option[Int]) => {
        val newCount = buffer.getOrElse(0) + seq.sum
        Option(newCount)
      }
    )
    value2.print()

    ssc.start()
    ssc.awaitTermination()
  }
}
