package spark.SQL.wordcount

import spark.utils.Utils

object Dataset extends App {

  val spark = Utils.getSparkSession("load-json-file")
  import spark.implicits._
  val ds = spark.read.json("/Users/gauravkantrod/Desktop/BigData/olc/scala/words.txt").as[String]



  println("Done")
}