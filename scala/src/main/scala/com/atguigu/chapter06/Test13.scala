package com.atguigu.chapter06

object Test13 {
  def main(args: Array[String]): Unit = {

    val dog = Dog.apply()
    dog.age = 18
    dog.name = "alice"
    println(dog.toString)

    val mike = Dog.apply("mike",20)
    println(mike.toString)

  }
}

class Dog private() {   // this must be inspective what you see

  var name:String = _
  var age:Int = _

  private def this(name:String,age:Int) {
    this
    this.age = age
    this.name = name
  }

  override def toString: String = s"Dog[name=$name,age=$age]"

}

object Dog{

  def apply(): Dog = new Dog()

  def apply(name: String, age: Int): Dog = new Dog(name, age)

}


class Cat private(){

}



