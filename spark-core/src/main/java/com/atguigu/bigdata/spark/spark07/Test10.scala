import org.apache.spark.{SparkConf, SparkContext}

object Test10 {

  def main(args: Array[String]): Unit = {

    // TODO Spark 转换算子
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDDCreate")
    val sc = new SparkContext(sparkConf)

    // TODO sortByKey
    //        val rdd = sc.makeRDD(List(
    //            ("a", 1), ("c",2), ("b", 3)
    //        ))
    val rdd = sc.makeRDD(List(
      (new User(), 1), (new User(),2), (new User(), 3)
    ))

    // TODO sortBy底层实现就是sortByKey
    // TODO sortByKey底层使用了范围分区器（RangePartitioner）
    // TODO sortByKey要求key类型是可以进行比较排序, key需要混入特质Ordered
    //rdd.sortBy(_._2)
    rdd.sortByKey(true).collect().foreach(x=>println(x))



    sc.stop()
  }
  class User extends Ordered[User]{
    override def compare(that: User): Int = -1
  }
}
