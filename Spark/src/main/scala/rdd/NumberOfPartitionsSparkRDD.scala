package rdd

import org.apache.spark.sql.SparkSession

object NumberOfPartitionsSparkRDD extends App {

  val spark = SparkSession.builder().master("local[3]").appName("File-Partitions").getOrCreate()
  val sc = spark.sparkContext
  sc.setLogLevel("ERROR")

  val lst = (1 to 100).toList
  val rdd1 = sc.parallelize(lst)
  println(rdd1.getNumPartitions)

  val rdd2 = sc.parallelize(lst, 2)
  println(rdd2.getNumPartitions)

  val rdd3 = sc.textFile("/Users/gauravkantrod/Desktop/BigData/olc/spark/spark-streaming/employee.txt")
  println(rdd3.getNumPartitions)

  val rdd4 = sc.textFile("/Users/gauravkantrod/Desktop/BigData/olc/spark/spark-streaming/employee.txt", 1)
  println(rdd4.getNumPartitions)


  println("Done")
}