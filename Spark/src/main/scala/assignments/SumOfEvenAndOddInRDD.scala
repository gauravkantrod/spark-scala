package assignments

import spark.utils.Utils

object SumOfEvenAndOddInRDD extends App {

  val spark = Utils.getSparkSession("even-odd-sum")
  val sc = spark.sparkContext

  val rdd = sc.makeRDD((1 to 5).toList, 3)

  rdd.map(ele => if (ele%2 == 0) ("Even", ele) else ("Odd", ele)).reduceByKey(_+_).foreach(println)



  println("Done.")

}
