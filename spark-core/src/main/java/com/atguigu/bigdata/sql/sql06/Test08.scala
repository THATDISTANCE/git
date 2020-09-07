package com.atguigu.bigdata.sql.sql06

object Test08 {
  def main(args: Array[String]): Unit = {

//    println(Person(Some("a"), Some(17)))
//
//    println(Person(Some("b"), null))
//
//    println(Person(null))
//
//    println(Person(Some("a")))

    val p = new Person("lisi",18)

    val tuple: (String, Int) = Person.unapply(p)

    println(tuple)

  }
}

//class Person(var name: String, var age: Int)
//object Person {
//  def unapply(p: Person): Tuple2[String, Int] = (p.name, p.age)
//}

class Person(var name : String , var age:Int)

object Person{
  def unapply(arg: Person): Tuple2[String,Int] = (arg.name,arg.age)
}