package com.atguigu.chapter11

object Test01 {
  def main(args: Array[String]): Unit = {

//    val v1: List[String] = List("hello","scala","spark","flink","hello","hello","scala","hello","scala","spark")
//
//    var v2 : Map[String,List[String]] = v1.groupBy(x=>x)
//
//    val v3: Map[String, Int] = v2.map(kv => (kv._1 , kv._2.length))
//
//    val v4: List[(String, Int)] = v3.toList
//
//    val v5 = v4.sortBy(_._2)(Ordering.Int.reverse)
//
//    val v6 = v5.take(3)
//
//    println(v6)

    val v1: List[(String, Int)] = List(("hello scala hello scala",4),("spark scala hello",2),("flink spark hello scala",1))

//    val v2: List[String] = v1.map(a => (a._1.trim + " ") * a._2)
//    val v3 = v2.map(_.split(" "))

//    println(v3.flatten.groupBy(x => x).toList.map(kv=>(kv._1,kv._2.length)).sortWith(_._2 >= _._2).take(3))
//    println(v3.flatten.groupBy(x => x).toList.map(kv=>(kv._1,kv._2.length)).sorted.takeRight(3)) //SORTED IS ONLY USEFUL TO TAKE RIGHT METHOD
//    println(v3.flatten.groupBy(x => x).toList.map(kv=>(kv._1,kv._2.length)).sortBy(_._2).reverse.takeRight(3))
//    println(v3.flatten.groupBy(x => x).toList.map(kv=>(kv._1,kv._2.length)).sortBy(_._2)(Ordering.Int.reverse).take(3))

    println(v1.map(a => (a._1.trim + " ") * a._2).map(_.split(" ")).flatten.groupBy(x => x).toList.map(a => (a._1, a._2.length)).sorted.takeRight(3))



  }
}
