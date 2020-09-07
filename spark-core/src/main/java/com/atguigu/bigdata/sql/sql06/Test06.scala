package com.atguigu.bigdata.sql.sql06

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.util.LongAccumulator

object Test06 {
  def main(args: Array[String]): Unit = {


    val conf = new SparkConf().setMaster("local[*]").setAppName("app")
    val ssc = new StreamingContext(conf,Seconds(3))





    ssc.stop()
    ssc.awaitTermination()
  }
}

object WordBlackList{

  private var instance : Broadcast[Seq[String]] = null

  def getInstance(sc:SparkContext)={
    if(instance == null){
      synchronized{
        if(instance == null){
          val blackList = Seq("a","b","c")
          instance = sc.broadcast(blackList)
        }
      }
    }
    instance
  }

}

object DroppedWordsCounter {

  @volatile private var instance: LongAccumulator = null

  def getInstance(sc: SparkContext): LongAccumulator = {
    if (instance == null) {
      synchronized {
        if (instance == null) {
          instance = sc.longAccumulator("WordsInBlacklistCounter")
        }
      }
    }
    instance
  }
}
