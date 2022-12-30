package spark.partitioningAndBucketing

import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import spark.utils.Utils

object PartitionBy extends App {

  val spark = Utils.getSparkSession("Join")
  val sc = spark.sparkContext
  sc.setLogLevel("ERROR")

  val employeeSchemaString = "empID,empName,empAge,deptID"
  val empSchema = employeeSchemaString.split(",").map(fieldname => StructField(fieldname, StringType, true))

  val empDF = spark.read.format("csv").option("header", false).schema(StructType(empSchema)).
    load("/Users/gauravkantrod/Desktop/BigData/olc/workspace/data/employee.txt")
  empDF.show()

  empDF.coalesce(2).write.mode(SaveMode.Overwrite).partitionBy("deptID")
    .parquet("/Users/gauravkantrod/Desktop/BigData/olc/workspace/output/emp/")

  val readSinglePartition = spark.read.format("parquet").option("header", false)
    .load("/Users/gauravkantrod/Desktop/BigData/olc/workspace/output/emp/deptID=3")
  readSinglePartition.show()

  println("Done")
}