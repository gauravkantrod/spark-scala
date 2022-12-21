package spark.com.testing.process

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import spark.utils.Utils

import java.util.UUID

object WordCountRDD extends App {
  def getWordCount(inputPath:String)(implicit sc:SparkContext):RDD[(String,Int)] = {
    val data = sc.textFile(inputPath)
    val wordCount = data.flatMap(ele => ele.split(" ")).map(ele => (ele.toLowerCase().trim, 1)).reduceByKey(_+_)
    wordCount
  }

  val inputPath = "src/main/resources/words.txt"
  val outputPath = "src/main/output/"
  implicit val sc = Utils.getSparkSession("word-count").sparkContext
  sc.setLogLevel("ERROR")

  val wordCount = getWordCount(inputPath)

  wordCount.collect().foreach(println)
  println(wordCount.getNumPartitions)
  wordCount.saveAsTextFile(s"${outputPath}${UUID.randomUUID()}")

  println("Done")
}