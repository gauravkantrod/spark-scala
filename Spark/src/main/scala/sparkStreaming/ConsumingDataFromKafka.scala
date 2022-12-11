package sparkStreaming

import org.apache.commons.codec.StringDecoder
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.streaming.kafka010.KafkaUtils
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.{Seconds, StreamingContext}

object ConsumingDataFromKafka extends App {

  case class Student(name:String, totalMarks:Int, schoolName:String, state:String, email:String)

  val spark = SparkSession.builder().master("local[*]").appName("Student-Kafka-Consumer-spark-Streaming").getOrCreate()
  val sc= spark.sparkContext
  val ssc = new StreamingContext(sc, Seconds(10)) // every 10 seconds a new DStream with 1 RDD will get generated

  val kafkaParameters = Map("bootstrap.servers" -> "localhost:9092", "key.deserializer" -> classOf[StringDeserializer],
    "value.deserializer" -> classOf[StringDeserializer], "group.id" -> "1")
  val topics = List("student-topic").toSet // there can be multiple topics

  val studentDataDStream = KafkaUtils.createDirectStream[String, String](ssc, PreferConsistent,
    Subscribe[String, String](topics, kafkaParameters))

  // flatmap will remove None object if there is length miss match
  val studentsDStream = studentDataDStream.flatMap(s => {
    val data = s.value().split(",")
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
  println(s"Filtered data is....")
  filteredDStream.print()
  //filteredDStream.count() // will give count of RDDs in DStream

  //now save data in hbase, hive, s3


  ssc.start()
  ssc.awaitTermination()
}