package sparkStreaming

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable

object SlidingWindowStreaming extends App {
  val spark = SparkSession.builder().master("local[*]").appName("Sliding-Window-Streaming").getOrCreate()
  val sc = spark.sparkContext
  val ssc = new StreamingContext(sc, Seconds(10)) // every 10 seconds 1 RDD would get consumed

  val inputDataQueue: mutable.Queue[RDD[String]] = mutable.Queue()
  inputDataQueue += sc.parallelize(List("apple", "ball", "apple"))
  inputDataQueue += sc.parallelize(List("apple", "ball", "apple"))
  inputDataQueue += sc.parallelize(List("apple", "ball", "apple"))
  inputDataQueue += sc.parallelize(List("apple", "ball", "apple", "cat", "cat"))
  inputDataQueue += sc.parallelize(List("apple", "ball", "apple"))
  inputDataQueue += sc.parallelize(List("apple", "ball", "apple"))
  inputDataQueue += sc.parallelize(List("apple", "ball", "apple"))
  inputDataQueue += sc.parallelize(List("apple", "ball", "apple"))
  inputDataQueue += sc.parallelize(List("apple", "ball", "apple"))
  inputDataQueue += sc.parallelize(List("apple", "ball", "apple"))

  val inputDataDStream = ssc.queueStream(inputDataQueue)
  val combinedDS = inputDataDStream.window(Seconds(20), Seconds(10))

  combinedDS.map((_,1)).reduceByKey(_+_).print()


  ssc.start()
  ssc.awaitTermination()
}