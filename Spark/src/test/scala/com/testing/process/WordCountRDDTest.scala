package com.testing.process

import com.holdenkarau.spark.testing.{DataFrameSuiteBase, SharedSparkContext}
import org.scalatest.funsuite.AnyFunSuite
import spark.com.testing.process.WordCountRDD

class WordCountRDDTest extends AnyFunSuite with SharedSparkContext with DataFrameSuiteBase{
  test("Test word count logic"){
    val inputPath = "src/test/resources/words-1.txt"
    implicit val sparkContext = sc
    val wordCount = WordCountRDD.getWordCount(inputPath).collectAsMap()
    assert(wordCount("apple") == 2)
    assert(wordCount("ball") == 2)
  }


  test("Test word count logic with spaces"){
    val inputPath = "src/test/resources/words-2.txt"
    implicit val sparkContext = sc
    val wordCount = WordCountRDD.getWordCount(inputPath).collectAsMap()
    assert(wordCount("apple") == 2)
    assert(wordCount("ball") == 2)
  }


}
