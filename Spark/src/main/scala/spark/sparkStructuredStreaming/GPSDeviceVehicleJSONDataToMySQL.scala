package spark.sparkStructuredStreaming

import org.apache.spark.sql.{Dataset, SparkSession}
import org.apache.spark.sql.functions._
import net.liftweb.json._
import org.apache.spark.sql.types.{StringType, StructField, StructType}

object GPSDeviceVehicleJSONDataToMySQL extends App {

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

  case class Vehicle(vehicleId: String, deviceID: String, driverID: String, timestamp: String, fuelLevel: String, speed: String)

  val spark = SparkSession.builder().master("local[*]").appName("WC-With-Window").getOrCreate()
  val sc = spark.sparkContext.setLogLevel("ERROR")

  import spark.implicits._
  implicit val formats = DefaultFormats

  val streamingDataDF = spark.readStream.format("socket").options(Map("host" -> "localhost", "port" -> "9999")).load()

  val schema = StructType(
    Array(
      StructField("vehicleId", StringType, true),
      StructField("deviceID", StringType, true),
      StructField("driverID", StringType, true),
      StructField("timestamp", StringType, true),
      StructField("fuelLevel", StringType, true),
      StructField("speed", StringType, true)
    )
  )

  val DF = streamingDataDF.withColumn("jsonData", from_json(col("value"), schema)).select("jsonData.*")

  DF.printSchema()

  val vehicleDS = streamingDataDF.as[String].map(jsonStringData => {
    val jValue = parse(jsonStringData)
    try{
      val v = jValue.extract[Vehicle]
      println(v.vehicleId)
      Vehicle(v.vehicleId, v.deviceID, v.driverID, v.timestamp, v.fuelLevel, v.speed)
    }
    catch{
      case e:ArrayIndexOutOfBoundsException => {
        println(s"found error -- ${e.getMessage}")
        Vehicle(null, null, null, null, null, null)
      }
      case e:Exception => println(s"Generic exception....")
        Vehicle(null, null, null, null, null, null)
    }
  })

  vehicleDS.writeStream.format("jdbc").outputMode("append").foreachBatch(saveToMySql _).start().awaitTermination()


  //val ds = streamingDataDF.as[String].flatMap(_.split(","))
  //ds.writeStream.format("jdbc").outputMode("append").foreachBatch(saveToMySql _).start().awaitTermination()
}