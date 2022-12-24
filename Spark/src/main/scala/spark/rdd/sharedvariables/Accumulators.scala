package spark.rdd.sharedvariables

import org.apache.spark.sql.SparkSession

object Accumulators extends App {

  val sc = SparkSession.builder().master("local[*]").appName("accumulators").getOrCreate().sparkContext
  sc.setLogLevel("ERROR")

  val acc = sc.longAccumulator("Counter of keys")



  println("Done")
}
