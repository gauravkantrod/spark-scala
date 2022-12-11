package com.testing.process

import org.apache.spark.sql.SparkSession
import utils.SparkUtils

object WordCountDF extends App {

  def getGenderWiseSalary(inputPath:String)(implicit sparkSession:SparkSession) = {
    val employeeDF =sparkSession.read.json(inputPath)
    val genderWiseSalary = employeeDF.groupBy("gender").avg("salary")
    genderWiseSalary
  }

  val inputPath = "src/main/resources/employee.json"
  val outputPath = "src/main/output/"
  implicit val sparkSession = SparkUtils.getSparkSession("Word-count-DF")
  val avgSalary = getGenderWiseSalary(inputPath)

  avgSalary.show(false)

  println("Done")
}