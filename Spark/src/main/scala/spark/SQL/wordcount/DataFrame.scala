package spark.SQL.wordcount

import org.apache.spark.sql.functions._
import spark.utils.Utils

object DataFrame extends App {

  val spark = Utils.getSparkSession("word-count")
  val sc = spark.sparkContext
  sc.setLogLevel("ERROR")

  import spark.implicits._
  val DF = spark.read.text("/Users/gauravkantrod/Desktop/BigData/olc/scala/words.txt")

  // Dataframe style
//  val words = DF.select(explode(split(DF("value"), " ")).alias("words"))
//  val lowercaseWords = words.select(lower(words("words")).alias("words"))
//  val count = lowercaseWords.groupBy(lowercaseWords("words")).count()
//  count.show()

  // Dataframe style
//  val wordsDF = DF.select(
//          explode(split($"value", " ")).as("words")
//        )
//  wordsDF.groupBy(lower($"words").as("uniqueWords")).count().show(false)


  // SQL style
  DF.createOrReplaceTempView("wordTable")

  spark.sql(" WITH splitWords AS (SELECT explode(split(value, ' ')) as words FROM wordTable), " +
    "lowerWord as (SELECT lower(words) as words FROM splitWords), " +
    "wordCount as (SELECT words, COUNT(2) as wordcount FROM lowerWord GROUP BY words ORDER BY words) " +
    "SELECT * FROM  wordCount").show(false)


  println("Done")

}
