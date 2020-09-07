package com.atguigu.chapter01

object Test11 {
  def main(args: Array[String]): Unit = {

    for(i <- 1 to 9 ; j <- i to 9){
      print(i+"*"+j+"="+i*j+"\t\t")
      if(j == 9) println()
    }

        var flag = 0
        var tmp = 1
        for(i <- 1 to 9 ; j <- 1 to i){
          flag = j
          print(i+"*"+j+"="+i*j+"\t\t")
          if(flag == tmp) {
            println()
            tmp+=1
          }
        }

  }
}
