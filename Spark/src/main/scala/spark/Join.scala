package spark

import org.apache.spark.sql.functions.col
import spark.utils.Utils

object Join extends App {

  val spark = Utils.getSparkSession("Join")
  val sc = spark.sparkContext
  sc.setLogLevel("ERROR")


  val empDF = spark.read.format("csv").option("header", false).
    load("/Users/gauravkantrod/Desktop/BigData/olc/workspace/data/person.txt")
  empDF.show()

  val deptDF = spark.read.format("csv").option("header", false).
    load("/Users/gauravkantrod/Desktop/BigData/olc/workspace/data/dept.txt")
  deptDF.show()

  val joinDF_1 = empDF.joinWith(deptDF, empDF("_c3") === deptDF("_c0"), joinType = "inner")//.show()

  joinDF_1.select(col("_1.*"), col("_2.*")).show()

//  val joinDF_2 = empDF.join(deptDF, empDF("_c3") === deptDF("_c0"), joinType = "inner")//.show()
//  joinDF_2.show()




  println("Done")
}