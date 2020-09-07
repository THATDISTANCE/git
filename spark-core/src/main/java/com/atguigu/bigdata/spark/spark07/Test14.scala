import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test14 {

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    val rdd: RDD[String] = sc.makeRDD(
      Array("hello world", "hello spark", "hive", "atguigu"))

    val search = new Search("hello")

//    // Task not serializable
//    search.getMatch1(rdd).collect().foreach(println)

    // Task not serializable
    search.getMatch2(rdd).collect().foreach(println)

    // 一般不考虑对象是否序列化的问题，因为声明类的时候都会采用case
    // 如果在class前使用case关键字进行声明，表示样例类
    // Scala在编译样例类的时候会自动让这个类实现可序列化接口
    // 并提供伴生对象以及常用的方法。
    // case class Test {}

    sc.stop()
  }
  // TODO 查询对象
  class Search(query:String) {

    // 方法和函数区别？
    // 方法其实就是函数
    // 一般将声明在类中的函数称之为方法，并且要遵循方法的限制和约束
    // 方法存在重载和重写的概念，但是函数没有
    // 方法的调用一般是通过对象来调用
    def isMatch(s: String): Boolean = {
      s.contains(query)
    }

    // 函数序列化案例
    def getMatch1 (rdd: RDD[String]): RDD[String] = {
      // TODO filter算子
      rdd.filter(this.isMatch)
    }

    // 属性序列化案例
    def getMatch2(rdd: RDD[String]): RDD[String] = {
      // TODO filter算子
      // query & Search
      //val q:String = query
      rdd.filter(x => x.contains(query))
    }
  }
}
