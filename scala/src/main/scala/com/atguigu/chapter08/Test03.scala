package com.atguigu.chapter08

object Test03 {
  def main(args: Array[String]): Unit = {
    println(Student01.getInstance.toString)
  }
}

class Student01 private (var name:String,var age:Int){
  override def toString: String = s"name=$name,age=$age"
}

//object Student01{
//  private val stu = new Student01("hello",10)
//  def getInstance() : Student01 = stu
//}

object Student01{
  private var stu : Student01 = _
  def getInstance = {

    if(stu == null){
      stu = new Student01("helo",19)
    }
    stu

  }
}

