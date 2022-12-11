package scalaBasics

import org.apache.spark.sql.SparkSession

object Fold extends App {

  val spark = SparkSession.builder().master("local[*]").appName("Fold-tutorial").getOrCreate()
  val sc = spark.sparkContext
  sc.setLogLevel("ERROR")

  val rdd = sc.makeRDD((1 to 5).toList, 1)
  //rdd.collect().foreach(println)

  val cubes = rdd.fold(0)((acc, num) =>{
    println(acc, num)
    acc + num*num*num
  })
  println(cubes)



  println("Done")
}