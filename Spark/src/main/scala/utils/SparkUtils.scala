package utils

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

object SparkUtils {

  def getSparkSession(appName:String):SparkSession = {
    val sparkSession = SparkSession.builder().master("local[*]").appName(appName).getOrCreate()
    sparkSession
  }

}
