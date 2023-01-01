package spark.sparkStructuredStreaming

import org.apache.spark.sql.{Dataset, Row, SparkSession}
import org.apache.spark.sql.functions.lit

object SavingStringDataFromSocketToMySQL extends App {


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

  val streamingDataDF = spark.readStream.format("socket").options(Map("host" -> "localhost", "port" -> "9999")).load()

  val vehicleDS = streamingDataDF.as[String].map(data => {
    val array = data.split(",")
    try{
      Vehicle(array(0), array(1), array(2), array(3), array(4), array(5))
    }
    catch{
      case e:ArrayIndexOutOfBoundsException => {
        println(s"found error -- ${e.getMessage}")
        println(s"Invalid record is --- ${data}")
        Vehicle(null, null, null, null, null, null)}
    }
  })

  vehicleDS.writeStream.format("jdbc").outputMode("append").foreachBatch(saveToMySql _).start().awaitTermination()
}