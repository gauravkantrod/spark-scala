package spark.sparkStreaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object StreamingAggregate extends App {

  val conf = new SparkConf().setMaster("local[*]").setAppName("Streaming-word-count")
  val ssc = new StreamingContext(conf, Seconds(10))
  val data = ssc.socketTextStream("localhost", 9999)

  val words = data.flatMap(_.split(" ")).map(_.toLowerCase)
  val pairedRDD = words.map((_,1))


  val updateFunc = (words:Seq[Int], state:Option[Int])=>{
    val previousCount = state.getOrElse(0)
    var currentCount = 0
    if (words.length >0) {
      currentCount = words.reduce(_+_)
    }
    Some(currentCount+previousCount)
  }

  ssc.checkpoint("word_count_checkpoint")
  val wordCount = pairedRDD.reduceByKey(_+_).updateStateByKey(updateFunc)
  wordCount.print()


  ssc.start()
  ssc.awaitTermination()
}