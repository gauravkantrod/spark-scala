package spark.SQL

import org.apache.spark.sql.Row
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import spark.utils.Utils

object DFSchema extends App {

  val spark = Utils.getSparkSession("DF-Schema")
  val sc = spark.sparkContext
  sc.setLogLevel("ERROR")

  val schemaString = "empId, empName, age, dept"
  val structFields = schemaString.split(",").map(fieldName => {
    StructField(fieldName, StringType, false)
  })
  val schema = StructType(structFields)

  val rdd = sc.textFile("/Users/gauravkantrod/Desktop/BigData/olc/workspace/data/person.txt")
  val rowRDD = rdd.map(_.split(",")).map(data => Row(data(0), data(1), data(2), data(3)))

  val DF = spark.createDataFrame(rowRDD, schema)

  DF.show(false)

  println("Done")
}