package spark

import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import spark.utils.Utils

object Salting extends App {

  val spark = Utils.getSparkSession("Join")
  val sc = spark.sparkContext
  sc.setLogLevel("ERROR")

  val employeeSchemaString = "empID,empName,empAge,deptID"
  val empSchema = employeeSchemaString.split(",").map(fieldname => StructField(fieldname, StringType, true))

  val empDF = spark.read.format("csv").option("header", false).schema(StructType(empSchema)).
    load("/Users/gauravkantrod/Desktop/BigData/olc/workspace/data/employee.txt")
  //empDF.show()

  empDF.createTempView("empTable")

  val saltedEmpDF = spark.sql("SELECT *, concat(deptID, '_', FLOOR(RAND(123)*11)) as empSaltedKey FROM empTable")
  saltedEmpDF.show()

  val deptSchemaString = "deptID,deptName"
  val deptSchema = deptSchemaString.split(",").map(fieldName => StructField(fieldName, StringType, true))

  val deptDF = spark.read.format("csv").option("header", false).schema(StructType(deptSchema)).
    load("/Users/gauravkantrod/Desktop/BigData/olc/workspace/data/dept.txt")
  //deptDF.show()

  deptDF.createTempView("deptTable")
  val deptSaltedDF = spark.sql(" WITH saltedCTE as (SELECT *, EXPLODE(ARRAY(1,2,3,4,5,6,7,8,9,10,11,12)) as deptSaltedKey FROM deptTable)," +
    " saltedOptimizedCTE as (SELECT deptID, deptName, CONCAT(deptID, '_', deptSaltedKey) as deptSaltedKey FROM saltedCTE) " +
    "SELECT * FROM saltedOptimizedCTE")
  deptSaltedDF.show()







  println("Done")
}