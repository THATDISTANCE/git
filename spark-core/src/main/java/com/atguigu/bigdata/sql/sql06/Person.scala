//package com.atguigu.bigdata.sql.sql06
//
//class Person {
//  var name: Option[String] = None
//  var age: Option[Int] = None
//  override def toString = s"$name, $age"
//}
//
//object Person {
//
//  // a one-arg constructor
//  def apply(name: Option[String]): Person = {
//    var p = new Person
//    p.name = name
//    p
//  }
//
//  // a two-arg constructor
//  def apply(name: Option[String], age: Option[Int]): Person = {
//    var p = new Person
//    p.name = name
//    p.age = age
//    p
//  }
//
//}