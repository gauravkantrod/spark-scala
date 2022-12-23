package spark.rdd

import org.apache.spark.sql.SparkSession

object Caching extends App {

  val sc = SparkSession.builder().master("local[*]").appName("Local-Iterator").getOrCreate().sparkContext
  sc.setLogLevel("ERROR")

  val rdd = sc.parallelize((1 to 100).toList)

  // internally use persist
  rdd.cache()

  rdd.unpersist()

}
