package scalaBasics.collection

object Mutable extends App {

  var mutableList = scala.collection.mutable.ListBuffer[Int]()
  mutableList += 6
  mutableList += 10
  mutableList += 11
  mutableList += 99
//  println(mutableList)
//  println(mutableList.init)
//
//  mutableList.inits.foreach(x => println(x.mkString("")))

}