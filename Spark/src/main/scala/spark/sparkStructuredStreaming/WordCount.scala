package spark.sparkStructuredStreaming

import org.apache.spark.sql.{DataFrame, SparkSession}

object WordCount extends App {

  val spark = SparkSession.builder().master("local[*]").appName("structured-streaming").getOrCreate()

  import spark.implicits._
  val DF = spark.readStream.format("socket").options(Map("host" -> "localhost", "port" -> "9999")).load()

  val words = DF.as[String].flatMap(x => x.split(" ")) // as will give dataset

  val wordCount = words.groupBy("value").count()

  val query = wordCount.writeStream.outputMode("complete").format("console").start()

  query.awaitTermination()
}