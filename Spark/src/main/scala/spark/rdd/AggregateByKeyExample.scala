package spark.rdd

import spark.utils.Utils

object AggregateByKeyExample extends App {
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
    ("M", 99),
    ("M", 90),
  )

  val rdd = sc.makeRDD(marks)

  val agg = rdd.aggregateByKey((0,0))(
    (v1,v2)=>(v1._1+v2, v1._2+1), // local aggregation will return (total_marks_of_subject, number_of_times_encountered)
    (v1,v2)=> (v1._1+v2._1, v1._2+v2._2) // global aggregation
  )

  agg.collect().foreach(println)

  println("Done.")
}