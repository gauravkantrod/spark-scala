package sparkStreaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object WordCountSingleDSStream extends App{
  val conf = new SparkConf().setMaster("local[*]").setAppName("Streaming-word-count")
  val ssc = new StreamingContext(conf, Seconds(10))
  val data = ssc.socketTextStream("localhost", 9999)

  val words = data.flatMap(_.split(" ")).map(_.toLowerCase)
  val pairedRDD = words.map((_,1))
  val wordCount = pairedRDD.reduceByKey(_+_)

  wordCount.print()

  ssc.start()
  ssc.awaitTermination()
}
