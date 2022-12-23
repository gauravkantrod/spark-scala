package assignments

import spark.utils.Utils

object EcommerceTxnRDD extends App {

  val spark = Utils.getSparkSession("average")
  val sc = spark.sparkContext
  sc.setLogLevel("ERROR")

//  1001,TV,5000
//  1002,Mobile,6000
//  1002,Watch,4000
//  1001,Bat,6000
//  1001,Camera,8000
  val rddRaw = sc.textFile("/Users/gauravkantrod/Desktop/BigData/olc/spark/rdd/ecommerce-transaction.txt")

  val extractedRDD = rddRaw.map(_.split(",")).map(ele => (ele(0), ele(2).toFloat))
  val totalExpense = extractedRDD.reduceByKey(_+_)
  totalExpense.collect().foreach(println)

  val sortedRdd = extractedRDD.map(ele => (ele._2, ele._1)).sortByKey(false).first()
  println(sortedRdd._1) // most expensive expense by any customer



  println("Done.")
}