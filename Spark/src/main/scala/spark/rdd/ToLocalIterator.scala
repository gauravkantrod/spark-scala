package spark.rdd

import org.apache.spark.sql.SparkSession

object ToLocalIterator extends App {

  val sc = SparkSession.builder().master("local[*]").appName("Local-Iterator").getOrCreate().sparkContext

  val rdd = sc.parallelize((1 to 100).toList)

  rdd.toLocalIterator.foreach(println)

}
