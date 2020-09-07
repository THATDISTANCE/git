package com.atguigu.bigdata.sql.sql04

object Test04 {
  def main(args: Array[String]): Unit = {

    def getPrintableString(p: Person): String = p match {
      case Student(name, year) =>
        s"$name is a student in Year $year."
      case Teacher(name, whatTheyTeach) =>
        s"$name teaches $whatTheyTeach."
    }


    val s = Student("Al", 1)
    val t = Teacher("Bob Donnan", "Mathematics")

    println(getPrintableString(s))
//    getPrintableString(t)


    println(s.copy(name = "lihang"))

  }


}
trait Person {
  def name: String
}
case class Student(name: String, year: Int) extends Person
case class Teacher(name: String, specialty: String) extends Person