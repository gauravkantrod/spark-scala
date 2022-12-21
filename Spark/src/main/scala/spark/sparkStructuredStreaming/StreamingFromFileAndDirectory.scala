package spark.sparkStructuredStreaming

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.streaming.Trigger
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object StreamingFromFileAndDirectory extends App {

  val spark = SparkSession.builder().master("local[*]").appName("structured-streaming-from-directory").getOrCreate()

  val schema = StructType(
    Array(StructField("name", StringType, true),
      StructField("marks", IntegerType, true),
      StructField("schoolName", StringType, true),
      StructField("state", StringType, true),
      StructField("email", StringType, true)
  ))

  import spark.implicits._
  val DF = spark.readStream.option("header", false).
    schema(schema).
    csv("/Users/gauravkantrod/Desktop/BigData/olc/spark/spark-structured-streaming/student-data-input/")

  val filteredDS = DF.filter($"marks" > 500)

//  val query = filteredDS.writeStream.
//    format("console").outputMode("append").
//    trigger(Trigger.ProcessingTime(1000.toLong))
//    .option("checkpointLocation","/Users/gauravkantrod/Desktop/BigData/olc/spark/spark-structured-streaming/check-pointing/")
//    .start()

  val query = filteredDS.
    writeStream.
    format("csv").
    outputMode("append").
    trigger(Trigger.ProcessingTime(1000.toLong))
    .option("checkpointLocation","/Users/gauravkantrod/Desktop/BigData/olc/spark/spark-structured-streaming/check-pointing/")
    .option("path", "/Users/gauravkantrod/Desktop/BigData/olc/spark/spark-structured-streaming/student-data-output/")
    .start()

  query.awaitTermination()
}