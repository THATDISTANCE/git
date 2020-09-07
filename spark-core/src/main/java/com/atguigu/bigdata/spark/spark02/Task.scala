package com.atguigu.bigdata.spark.spark02

case class Task(){
    val task = List(1,2,3,4)
    val commond:Int=>Int = task => task * 2
    def compute(): List[Int] ={
      task.map(commond)
    }
}
