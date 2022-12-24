package spark.rdd

import org.apache.spark.sql.SparkSession

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object ReadAllTheFilesFromDirectory extends App {

  val sc = SparkSession.builder().master("local[*]").appName("accumulators").getOrCreate().sparkContext
  sc.setLogLevel("ERROR")

  val fileRDD = sc.wholeTextFiles("/Users/gauravkantrod/Desktop/BigData/olc/scala/readAllFiles/num*.txt", 5)
  val formattedDataRDD = fileRDD.map{case(file, nums)=>{
    val lst = nums.split(",|\\n").map(_.toInt)
    val avg = lst.reduce(_+_)/lst.size.toFloat
    (file, avg)
  }}

  //formattedDataRDD.collect().foreach(println)

  val lineWiseSum = fileRDD.map{case(filepath, nums)=>{

    val abf = ArrayBuffer[ArrayBuffer[Int]]()
    nums.split("\\n").foreach(ele =>{
      val numData = ele.split(",").map(_.toInt)
      val numArray = ArrayBuffer[Int]()
      numData.foreach(num => numArray+=num)
      abf += numArray
    })

    abf

  }}

  lineWiseSum.collect().foreach(println)


  println("Done")
}