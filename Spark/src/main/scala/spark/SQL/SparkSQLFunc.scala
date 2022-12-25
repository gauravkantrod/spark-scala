package spark.SQL

import spark.utils.Utils

object SparkSQLFunc extends App {
  val spark = Utils.getSparkSession("Spark-SQL-Funcs")
  val sc = spark.sparkContext
  sc.setLogLevel("ERROR")

  //spark.sql("SELECT !false").show()

  // format is yyyy-mm-dd hr:mins:secs
  spark.sql("SELECT to_date('1994-10-30 12:59:59') < to_date('1994-10-31') ").show()


  println("Done")
}