package spark.SQL

import spark.utils.Utils

object LoadJsonFile extends App {

  val spark = Utils.getSparkSession("load-json-file")
  val DF = spark.read.json("/Users/gauravkantrod/Desktop/BigData/olc/scala/emp.json")
  //DF.cache()
  //DF.show(false)

//  DF.createTempView("employee")
//  val sqlDF = spark.sql("SELECT * FROM employee")
//  sqlDF.show()



  println("Done")
}