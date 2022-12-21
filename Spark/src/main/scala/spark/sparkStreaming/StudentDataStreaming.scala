package spark.sparkStreaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object StudentDataStreaming extends App {

  case class Student(name:String, totalMarks:Int, schoolName:String, state:String, email:String)

  val conf = new SparkConf().setMaster("local[*]").setAppName("Streaming-word-count")
  val ssc = new StreamingContext(conf, Seconds(10))
  val studentDataDStream = ssc.socketTextStream("localhost", 9999)

  val studentsDStream = studentDataDStream.map(s => {
    val data = s.split(",")
    println(data)
    Student(data(0), data(1).toInt, data(2), data(3), data(4))
  })

  val filteredDStream = studentsDStream.filter(_.totalMarks > 500)
  filteredDStream.print()

  ssc.start()
  ssc.awaitTermination()
}