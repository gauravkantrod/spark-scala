package spark

import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import spark.utils.Utils

object UDF extends App {

  val spark = Utils.getSparkSession("Join")
  val sc = spark.sparkContext
  sc.setLogLevel("ERROR")

  val employeeSchemaString = "empID,empName,empAge,deptID"
  val empSchema = employeeSchemaString.split(",").map(fieldname => StructField(fieldname, StringType, true))

  val empDF = spark.read.format("csv").option("header", false).schema(StructType(empSchema)).
    load("/Users/gauravkantrod/Desktop/BigData/olc/workspace/data/employee.txt")
  empDF.show()


  def getStringUniqueNumber(s: String,const:Int=1): Double = {
    var total:Double = 0
    val len = s.length
    0.until(len).foreach(id => {
      val charToInt = s(id).toDouble
      total += math.pow(10.0, charToInt)
    })
    total
  }

  val uniqueNumberUDF = udf(getStringUniqueNumber(_:String, _:Int))

  empDF.select(uniqueNumberUDF(col("empName"), lit(1)).as("uniqueKey"), col("empAge")
  ).show()


  println("Done")
}