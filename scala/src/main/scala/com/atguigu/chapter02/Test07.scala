package com.atguigu.chapter02

object Test07 {
  def main(args: Array[String]): Unit = {
//    def v1(name:String*) = {
//      println("hello")
//    }
//
//    v1()

//    def v2(sex:String,name:String*)={
//      println(sex+name)
//    }
//
//    v2("male","mike","lisi")

//    def v3(age:Int,name:String,sex:String = "male")={
//      println(name+" , "+age+" , "+sex)
//    }
//
//    v3(17,"zhangsan")
//    def v1(name:String):String = {
//      return name
//    }
//
//    def v2(name:String):String = {
//      name
//    }

//    def v3(name:String) = {
//      name
//    }
//
//    def v4(name:String) = name
//
//    def v5(name:String){
//      println(name)
//    }
//
//    def v6(){ println("hello")}
//
//    v6()
//    v6

//    def v7(){}
//    def v8()={}

//    def v7(name:String) {println("hello")}
//    def v8(name:String) = "hello"
//    println(v8("helo"))

//    var i = (x:Int)=>(x*x);  println(i(3))
//
//    def v9(fun:Int=>Int)={
//      fun(5)
//    }
//
//    println(v9(i))

//    var i = (name:String)=>(println("this is new name "+name))

//    i1((name:String)=>(println("this is new name "+name)))
//
//    def i1(fun:String=>Unit): Unit ={
//      fun("mike")
//    }
//    i1((name=>println("this is new name "+name)))
//    i1(name=>println("this is new name "+name))

    ((name:String)=>(println(name)))("hello")
    ((age:Int)=>(println(age)))(3)

  }
}
