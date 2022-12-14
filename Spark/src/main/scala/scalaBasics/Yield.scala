package scalaBasics

object Yield extends App {

  val lst = (1 to 100).toList

  val y = for(i <- lst) yield i
  println(y)

  val y2 = for(i <- 1 to 5) yield i
  println(y2)

  val y3 = for(i <- 1 to 9 if i > 4) yield i
  println(y3)
}