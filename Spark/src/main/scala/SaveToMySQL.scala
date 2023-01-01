import org.apache.spark.sql.{SaveMode, SparkSession}

object SaveToMySQL extends App {

  val spark = SparkSession.builder().master("local[*]").appName("WC-With-Window").getOrCreate()
  val sc = spark.sparkContext.setLogLevel("ERROR")
  import spark.implicits._

  val dataDF = List(
    (101, "Gaurav"),
    (102, "Sneha"),
    (103, "Golu")
  ).toDF("id", "name")


  dataDF.write
    .format("jdbc")
    .option("driver","com.mysql.cj.jdbc.Driver")
    .option("url", "jdbc:mysql://localhost:3306/device")
    .option("dbtable", "employee")
    .option("user", "root")
    .option("password", "mySQL@123")
    .mode(SaveMode.Append)
    .save()

  println("Done")
}