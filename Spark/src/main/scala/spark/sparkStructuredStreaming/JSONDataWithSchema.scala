package spark.sparkStructuredStreaming

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions.{col, from_json}
import org.apache.spark.sql.types.{StringType, StructField, StructType}

object JSONDataWithSchema extends App {

  // make sure to create table with vehicleGPS in database
  def saveToMySql(df: DataFrame, batchId: Long): Unit = {
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

  // use dataset approach as in this approach if JSON is broken then it would go undetected. Write try cath in dataset method
  val DF = streamingDataDF.select(from_json(col("value"), schema).as("jsonData")).select("jsonData.*")
  DF.printSchema()

  DF.writeStream.format("jdbc").outputMode("append").foreachBatch(saveToMySql _).start().awaitTermination()
}