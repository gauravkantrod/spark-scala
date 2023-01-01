package spark.sparkStructuredStreaming

import net.liftweb.json.{DefaultFormats, parse}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.sql.{Dataset, SparkSession}

object SaveJSONToMySQLDatabaseFromKafka extends App {

  def saveToMySql(df: Dataset[Vehicle], batchId: Long): Unit = {
    println("Writing data....")

    // make sure columns in df are same as columns in table in database
    df
      //.withColumn("batchId", lit(batchId))
      .write
      .format("jdbc")
      .option("driver", "com.mysql.cj.jdbc.Driver")
      .option("url", "jdbc:mysql://localhost:3306/device")
      .option("dbtable", "vehicleGPS")
      .option("user", "root")
      .option("password", "mySQL@123")
      .mode("append")
      .save()
  }

  case class Vehicle(vehicleId: String, deviceID: String, driverID: String, timestamp: String, fuelLevel: String,
                     speed: String, isValid:Boolean)

  val spark = SparkSession.builder().master("local[*]").appName("WC-With-Window").getOrCreate()
  val sc = spark.sparkContext.setLogLevel("ERROR")
  import spark.implicits._
  implicit val formats = DefaultFormats

  // create topic with replication-factor and partitions and make sure data goes to leader partition
  val df = spark.readStream
    .format("kafka")
    .option("kafka.bootstrap.servers", "localhost:9092")
    .option("subscribe", "jsontopic")
    .option("startingOffsets", "earliest") // From starting
    .load()

//  val vehicleStringDF = df.selectExpr("CAST(value AS STRING)")
  val vehicleStringDS = df.as[String] //.selectExpr("CAST(value AS STRING)").as[String]

//  val schema = StructType(
//    Array(
//      StructField("vehicleId", StringType, true),
//      StructField("deviceID", StringType, true),
//      StructField("driverID", StringType, true),
//      StructField("timestamp", StringType, true),
//      StructField("fuelLevel", StringType, true),
//      StructField("speed", StringType, true)
//    )
//  )

  // this approach will not let us filter out corrupt records
//  val processedDataDF = vehicleStringDF.select(from_json(col("value"), schema).as("data")).select("data.*")

  val vehicleDS = vehicleStringDS.map(jsonStringData => {
    val jValue = parse(jsonStringData)
    try{
      val v = jValue.extract[Vehicle]
      println(v.vehicleId)
      Vehicle(v.vehicleId, v.deviceID, v.driverID, v.timestamp, v.fuelLevel, v.speed, true)
    }
    catch{
      case e:ArrayIndexOutOfBoundsException => {
        println(s"found error -- ${e.getMessage}")
        Vehicle(null, null, null, null, null, null, false)
      }
      case e:Exception => println(s"Generic exception....")
        Vehicle(null, null, null, null, null, null, false)
    }
  })

  vehicleDS.writeStream.outputMode("append").format("console").start().awaitTermination()
}