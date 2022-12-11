package kafka

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
import java.util.Properties
import scala.io.Source

object Producer extends App {

  val props = new Properties()
  props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
  props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
  props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")

  val topic = "student-topic"
  val producer = new KafkaProducer[String,String](props)

  for(i <- 1 to 10){
    for (line <- Source.fromFile("/Users/gauravkantrod/Desktop/BigData/olc/spark/spark-streaming/student.txt").getLines()){
      val data = line.split(",")
      val key = data(3)
      val value = line

      val record = new ProducerRecord[String,String](topic, key, value)
      producer.send(record)
      println(line)
    }
    println(s"Thread sleeping...${i}")
    Thread.sleep(10000)
  }

  producer.close()
  println("Data produced successfully...")
}