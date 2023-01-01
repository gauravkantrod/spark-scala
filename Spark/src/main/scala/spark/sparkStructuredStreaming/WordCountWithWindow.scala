package spark.sparkStructuredStreaming

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{StringType, StructField, StructType, TimestampType}
import org.apache.spark.streaming.Seconds

object WordCountWithWindow extends App {

  val spark = SparkSession.builder().master("local[*]").appName("WC-With-Window").getOrCreate()
  val sc = spark.sparkContext.setLogLevel("ERROR")
  import spark.implicits._

  val schema = StructType(Array(
    StructField("timestamp", TimestampType, true),
    StructField("words", StringType, true)
  ))
  case class Word(timestamp:String, words:String)

  val socketDF = spark.readStream.format("socket").
    options(Map("host" -> "localhost", "port" -> "9999")).
    load()

  println(socketDF.printSchema())
  println(socketDF.isStreaming)
  val splitDF = socketDF.select(split(col("value"), "\\|")(0).as("timestamp"),
    split(col("value"), "\\|")(1).as("words"))

  //val wordDF = splitDF.as[Word]

  splitDF.createTempView("table")




  splitDF.writeStream.outputMode("append").format("console").start().awaitTermination()





}
