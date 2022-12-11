package sparkStreaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

import java.util.UUID

object StreamingFromFile extends App {
  case class Student(name:String, totalMarks:Int, schoolName:String, state:String, email:String)

  val conf = new SparkConf().setMaster("local[*]").setAppName("Streaming-Student-from-file")
  val ssc = new StreamingContext(conf, Seconds(30))
  val studentDataDStream = ssc.textFileStream("/Users/gauravkantrod/Desktop/BigData/olc/spark/spark-streaming/streaming-from-file/student-data-input/")

  // flatmap will remove None object if there is length miss match
  val studentsDStream = studentDataDStream.flatMap(s => {
    val data = s.split(",")
    if(data.length == 5){
      println("Data with correct length/schema")
      println(data.mkString("[","||","]"))
      Some(Student(data(0), data(1).toInt, data(2), data(3), data(4)))
    }
    else{
      println("Data with incorrect schema..")
      println(data.mkString("[","||","]"))
      None
    }
  })

  val filteredDStream = studentsDStream.filter(_.totalMarks > 500)
  filteredDStream.print()
  filteredDStream.count() // will give count of RDDs in DStream

  filteredDStream.foreachRDD(rdd => {
    val uuid = UUID.randomUUID()
    if (rdd.count() != 0){
      rdd.saveAsTextFile(s"/Users/gauravkantrod/Desktop/BigData/olc/spark/spark-streaming/streaming-from-file/student-data-output/${uuid}")
    }
  })

  //filteredDStream.saveAsTextFiles("/Users/gauravkantrod/Desktop/BigData/olc/spark/spark-streaming/streaming-from-file/student-data-output/")


  ssc.start()
  ssc.awaitTermination()
}
