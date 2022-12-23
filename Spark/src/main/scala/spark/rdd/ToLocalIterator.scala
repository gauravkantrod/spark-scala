package spark.rdd

import org.apache.spark.sql.SparkSession

object ToLocalIterator extends App {

  val sc = SparkSession.builder().master("local[*]").appName("Local-Iterator").getOrCreate().sparkContext
  sc.setLogLevel("ERROR")

  val rdd = sc.parallelize((1 to 5).toList, 5)

  //rdd.toLocalIterator.foreach(println)
  //rdd.top(10)(Ordering[Int].reverse).foreach(println)
  //rdd.countByValue().foreach(println)

//  val cube = rdd.fold(0)((acc, num)=>{
//    println(acc, num)
//    acc + num*num*num
//  })
//  println(cube)

//  rdd.mapPartitions(it =>{
//    val cube = it.fold(0)((acc, num)=>{
//      acc + num*num*num
//    })
//    println(cube)
//    it
//  })

//  val localAgg = (acc:(Int, Int), num:Int) => (acc._1+num, acc._2+1)
//  val globalAgg = (acc1:(Int, Int), acc2:(Int, Int)) => (acc1._1+acc2._1, acc1._2+acc2._2)
//  val agg = rdd.aggregate(0,0)(localAgg, globalAgg)
//
//  println(agg)
}