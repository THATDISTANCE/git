package com.atguigu.bigdata.sql.sql06

object Test09 {
  def main(args: Array[String]): Unit = {

    def toInt(s : String) : Option[Int] = {
      try{
        Some(Integer.parseInt(s))
      }catch {
        case e:Exception => None
      }
    }
//
//    val tmp = "123"
//
//    toInt(tmp) match {
//      case Some(i) => println(i)
//      case None => println(None)
//    }

//    def toInt(s:String):Try[Int]=Try{
//      Integer.parseInt(s)
//    }
//
//    println(toInt("zhang"))
//    println(toInt("1234"))


//    Option(3).foreach(println(_))
//    Option(4).map((_,1)).foreach(println)




  }
}
