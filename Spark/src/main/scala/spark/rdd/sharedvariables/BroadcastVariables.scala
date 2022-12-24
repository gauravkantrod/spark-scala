package spark.rdd.sharedvariables

import org.apache.spark.sql.SparkSession

object BroadcastVariables extends App {

  val sc = SparkSession.builder().master("local[*]").appName("accumulators").getOrCreate().sparkContext
  sc.setLogLevel("ERROR")

  // nae=me, age, deptId
  val empList = Seq(
    ("Gaurav", 1),
    ("Shashi", 1),
    ("T2", 2),
    ("Ashish", 3),
    ("Nunu", 4)
  )

  //deptId, deptName
  val deptList = Seq(
    (1, "IT"),
    (2, "HR"),
    (5, "Sales")
  )

  val empRDD = sc.parallelize(empList).map(ele => (ele._2, ele._1))
  val deptRDD = sc.makeRDD(deptList)
  val broadcastDept = sc.broadcast(deptRDD.collectAsMap())

  val innerJoinRDD = empRDD.flatMap(ele=>{
    broadcastDept.value.get(ele._1).map(othervalue => (ele._1, (ele._2, othervalue)))
  })

  innerJoinRDD.collect().foreach(println)


  println("Done")
}