package spark.sparkStructuredStreaming

import spark.utils.Utils.getSparkSession

object WordCountRepeat extends App {

  val spark = getSparkSession("WC-Repeat")
  val sc = spark.sparkContext
  sc.setLogLevel("ERROR")

  import spark.implicits._
  val data = spark.readStream.format("socket").option("host", "localhost").options(Map("port" -> "9999")).load()

   val words = data.as[String].flatMap(_.split(" ")).map(_.toLowerCase())

  words.writeStream.format("console").outputMode("append").start().awaitTermination()



}
