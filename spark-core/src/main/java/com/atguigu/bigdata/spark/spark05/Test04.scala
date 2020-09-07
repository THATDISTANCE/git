package com.atguigu.bigdata.spark.spark05

import com.atguigu.bigdata.spark.spark05.Test04.Emp

object Test04 extends Parent1 with Parent3 {
  def main(args: Array[String]): Unit = {

    new Emp().insert()
    new Emp().update()


    //    implicit class EmpExt(emp: Emp){
    //      def update(): Unit ={
    //        println("updating ... ")
    //      }
    //    }
  }
    class Emp {
      def insert() = {
        println("insert ...")
      }
    }
}
  class Parent1 {

//    implicit class Ext(emp: Emp) {
//      def update() = {
//        println("updating ...")
//      }
//    }
  }
  trait Parent3{
    implicit class Ext(emp: Emp){
      def update()={
        println("updating ...")
      }
    }
  }

  object Parent4{
    implicit class Ext(emp: Emp){
      def update()={
        println("updating ...")
      }
    }
  }

