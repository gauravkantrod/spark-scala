package spark.SQL.wordcount

import spark.utils.Utils

object Dataset extends App {

  val spark = Utils.getSparkSession("word-count-Dataset-code")
  import spark.implicits._
  val ds = spark.read.text("/Users/gauravkantrod/Desktop/BigData/olc/scala/words.txt").as[String]

  ds.flatMap(_.split(" ")).groupByKey(_.toLowerCase()).count().show()


  println("Done")
}