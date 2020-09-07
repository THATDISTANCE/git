package com.atguigu.bigdata.sql.sql05

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object Test04 {



  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("app")
    val ssc = new StreamingContext(conf,Seconds(3))

    val props = new Properties()
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "hadoop102:9092,hadoop103:9092,hadoop104:9092")
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")


    val producer = new KafkaProducer[String,String](props)

   while( true ){
     for (data <- getDate())
      producer.send(new ProducerRecord[String,String](
        "sgg0421",
        data
      ))
     Thread.sleep(2000)
    }

    ssc.start()
    ssc.awaitTermination()
  }

  def getDate(): Array[String] = {
      val array: ArrayBuffer[String] = ArrayBuffer[String]()
      val areaList = List("华北","华南","华中")
      val cityList = List("上海","北京","深圳")

      val random = new Random()

    for ( i <- 1 to 5){

      val timestamp: Long = System.currentTimeMillis()
      val area: String = areaList(random.nextInt(3))
      val city: String = cityList(random.nextInt(3))
      val adid: Int = 1 +  random.nextInt(6)
      val userid: Int = 1 + random.nextInt(6)

      array += timestamp + " " + area + " " + city + " " + userid + " " + adid

    }

    array.toArray
  }

}
