package com.atguigu.bigdata.sql.sql05

object Test07 {
  def main(args: Array[String]): Unit = {

    new Thread(new Runnable {
      override def run(): Unit = {
        for (i <- 1 to 100){
          println("==="+i)
        }
      }
    }).start()

  }
}
