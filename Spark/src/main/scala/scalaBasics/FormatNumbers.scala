package scalaBasics

object FormatNumbers extends App {

  println("%07d".format(2000))
  println("%07d".format(10000))

  println("%.2f".format(123.456))
  println(Math.floor(123.456))
  println("%013.4f".format(123.456))
  // println("%02f".format(123)) // will throw error

}