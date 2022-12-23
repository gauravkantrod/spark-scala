package assignments

import spark.utils.Utils

object RDDJoins extends App {
  val spark = Utils.getSparkSession("average")
  val sc = spark.sparkContext
  sc.setLogLevel("ERROR")

  val students = Seq(
    (101, "Gaurav"),
    (102, "Shashi"),
    (103, "Ayesha"),
    (104, "Shivani"),
    (105, "Harshit")
  )
  val feesPaid = Seq(
    (101, true), (103, true), (104, true))

  val sRDD = sc.makeRDD(students)
  val fRdd = sc.parallelize(feesPaid)

  // find which student has paid fees
  val op = sRDD.join(fRdd).map(ele => (ele._1, ele._2._1))
  //op.collect().foreach(println)

  sRDD.subtract(op).collect().foreach(println)

//  val feesMissed = sRDD.keys.subtract(op.keys)
//  feesMissed.collect().foreach(println)

}
