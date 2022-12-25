package spark.SQL

import spark.utils.Utils
import org.apache.spark.sql.functions._

object LoadJsonFile extends App {

  val spark = Utils.getSparkSession("load-json-file")
  val DF = spark.read.option("multiline",true).format("json").
    load("/Users/gauravkantrod/Desktop/BigData/olc/workspace/data/emp.json")
  val sc = spark.sparkContext
  sc.setLogLevel("ERROR")
  //DF.cache()
  DF.show(false)
  DF.printSchema()

  //DF.select(explode(col("orders"))).show()

  //DF.select(col("*"), lit("MFCC").as("shopName")).show()

  //DF.select(col("*"), explode(col("email"))).show()

  DF.select(col("name"),col("dob"), col("salary"),
    col("communication.phones.home"), col("communication.phones.mobile"),
    col("communication.address.area"), col("communication.address.district"),
    col("communication.address.pin"),
    col("email").getItem(0).as("primary_email"),
    col("email").getItem(1).as("secondary_email")
  ).show()

  println("Done")
}