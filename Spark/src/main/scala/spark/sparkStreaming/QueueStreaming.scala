package spark.sparkStreaming

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable

object QueueStreaming extends App {

  val spark = SparkSession.builder().master("local[*]").appName("Streaming-Queue").getOrCreate()
  val sc = spark.sparkContext
  val ssc = new StreamingContext(sc, Seconds(10))

  val rdd1 = sc.makeRDD((1 to 5).toList)
  val rdd2 = sc.parallelize(List(6,7,8,9,10))

  val inputQueue:mutable.Queue[RDD[Int]] = mutable.Queue()
  inputQueue += rdd1
  inputQueue += rdd2

  val inputQueueDStream = ssc.queueStream(inputQueue)

  val evenODDDStream = inputQueueDStream.transform(rdd =>{
    rdd.map(num => {
      val rem = num%2
      rem match {
        case 0 => ("EVEN", num)
        case _ => ("ODD", num)
      }
    })
  })

  val total = evenODDDStream.reduceByKey(_+_)
  total.print()

  ssc.start()
  ssc.awaitTermination()
}