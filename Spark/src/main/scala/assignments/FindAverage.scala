package assignments

import spark.utils.Utils

object FindAverage extends App {

  val spark = Utils.getSparkSession("average")
  val sc = spark.sparkContext
  sc.setLogLevel("ERROR")

  val marks = Seq(
    ("P", 50),
    ("C", 60),
    ("M", 65),
    ("P", 60),
    ("C", 70),
    ("M", 80),
  )

  val rdd = sc.makeRDD(marks)
  val summation = rdd.map(ele => (ele._1, (ele._2,1))).reduceByKey((ele1, ele2) => (ele1._1+ele2._1, ele2._2+ele2._2))
  val averageRDD = summation.mapValues(ele => ele._1/ele._2.toFloat)
  averageRDD.collect().foreach(println)

  println("Done.")
}