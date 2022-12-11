package sparkStreaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object MultipleDStream extends App {

  val conf = new SparkConf().setMaster("local[*]").setAppName("Streaming-word-count")
  val ssc = new StreamingContext(conf, Seconds(20))
  val ds1 = ssc.socketTextStream("localhost", 9999)
  val ds2 = ssc.socketTextStream("localhost", 8888)

  val combinedDS = ds1.union(ds2)

  val words = combinedDS.flatMap(_.split(" ")).map(_.toLowerCase)
  val pairedRDD = words.map((_,1))
  val wordCount = pairedRDD.reduceByKey(_+_)

  wordCount.print()

  ssc.start()
  ssc.awaitTermination()
}