package com.atguigu.chapter06

object Test07 {
  def main(args: Array[String]): Unit = {
//    val c = new C1()
//    c.name = "hello"
//    c.age = 18
//    println(c.toString)

//    val alice = new C2("alice",18)
//    println(alice.age+" , "+alice.name)

//    val alice = new C3("alice",19)

//    val alice = new C4("alice",20)
//    alice.age = 19
//    alice.name = "hello"

//   var alice = new C5("alice",27)
//    alice.school = "atguigu"
//    println(alice.toString)

    println(new C5("alice", 29, "qida").toString)


  }
}

class C1{
  var name:String = _
  var age:Int = _

  override def toString: String = s"name=$name,age=$age"
}

class C2(var name:String,var age:Int){}

class C3(name:String,age:Int){}

class C4(val name:String,val age:Int){}

class C5(var name:String,var age:Int){

  var school:String = _
  println("main constructor")

  def this(name:String,age:Int,school:String){
    this(name,age)
    this.school = school
    println("auxiliary constructor")
  }

  def printInfo()={
    println("hello , world !!")
  }

  override def toString: String = s"name=$name,age=$age,school=$school"

}

