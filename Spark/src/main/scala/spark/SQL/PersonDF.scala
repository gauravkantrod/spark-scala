package spark.SQL

import org.apache.spark.sql.functions._
import spark.utils.Utils

object PersonDF extends App {

  val spark = Utils.getSparkSession("person")
  val sc = spark.sparkContext
  import spark.implicits._

  val personRDD = sc.textFile("/Users/gauravkantrod/Desktop/BigData/olc/workspace/data/person.txt")
  val personDF = personRDD.toDF()

  //personDF.show()

  personDF.createTempView("personTable")

  val formattedDF = spark.sql(" SELECT SPLIT(value, ',')[0] as empID, SPLIT(value, ',')[1] as name," +
    "SPLIT(value, ',')[2] as age, SPLIT(value, ',')[3] as dept FROM personTable")

  formattedDF.show()

  val DataEngineerDF = formattedDF.select(col("*")).where($"dept" === "DE")

  DataEngineerDF.select(col("*"), ($"age"+2).as("newAge")).show(false)




  println("Done")
}