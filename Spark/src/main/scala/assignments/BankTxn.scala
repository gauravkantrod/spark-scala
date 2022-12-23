package assignments

import spark.utils.Utils

object BankTxn extends App {

  case class Txns(txnId:String, amt:Int)

  val spark = Utils.getSparkSession("Bank-Txns")
  val sc = spark.sparkContext
  sc.setLogLevel("ERROR")

//  SB10001,1000
//  SB10002,1200
//  SB10003,8000
//  SB10004,400
//  SB10005,300
//  SB10006,10000
//  SB10007,500
//  SB10008,56
//  SB10009,30
//  SB10010,7000
//  CR10011,7000
//  SB10012,-10
  val rddRaw = sc.textFile("/Users/gauravkantrod/Desktop/BigData/olc/spark/rdd/bank-transaction.txt")
  val extractedRDD = rddRaw.map(_.split(",")).map(ele => Txns(ele(0).trim, ele(1).trim.toInt))

  val validRecords = extractedRDD.filter(ele => (ele.txnId.contains("SB") & ele.amt>0))//.filter(_!=None)
  val invalidRecords = extractedRDD.filter(ele => (ele.amt < 0 | !ele.txnId.contains("SB")))//.filter(_!=None)

  validRecords.collect().foreach(println)
  println("-----------------------------")
  invalidRecords.collect().foreach(println)
  println("------------------------------")
  val amtGt1000 = validRecords.filter(_.amt>1000)
  amtGt1000.collect().foreach(println)
  println("-------------------------------")
  println(validRecords.count())
  println("--------------------------------")
  val totalAmt = validRecords.map(_.amt).reduce(_+_)
  println(totalAmt)
  println("---------------------------------")
  val maxAmt = validRecords.map(_.amt).max()
  println(maxAmt)
  println("---------------------------------")
  val minAmt = validRecords.map(_.amt).min
  println(minAmt)
  println("---------------------------------")

  println("Done.")
}