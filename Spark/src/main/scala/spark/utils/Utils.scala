package spark.utils

import org.apache.spark.sql.SparkSession

object Utils {

  def getSparkSession(appName:String):SparkSession = {
    val sparkSession = SparkSession.builder().master("local[*]").appName(appName).getOrCreate()
    sparkSession
  }

  def getUniqueInt(s: String): Int = {
    val numsSeq = s.zipWithIndex.map { case (c, idx) =>
      c.toInt * math.pow(10, idx)
    }
    numsSeq.reduce(_ + _).toInt
  }

//  println(getUniqueInt("GAURAV"))
//  println(getUniqueInt("URAVGA"))

}
