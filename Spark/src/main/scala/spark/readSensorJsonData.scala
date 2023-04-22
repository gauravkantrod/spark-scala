package spark

import org.apache.spark.sql.SparkSession

object readSensorJsonData extends App {

  val spark = SparkSession.builder().master("local[*]").appName("read-multiline-json-file").getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")

  val jsonFileDF = spark.read.format("json").option("multiline", true)
    .load("/Users/gauravkantrod/Desktop/BigData/olc/workspace/data/sensor-data.json")

  jsonFileDF.show(false)



  println("Done")
}