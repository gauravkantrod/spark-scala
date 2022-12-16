package scalaBasics.collection

object Sorting extends App {

  val lst = List(1,2,4,5,7,1,2,3,99,11)

  println(lst.sortWith(_>_))
  println(lst.sortWith(_<_))

  println(lst.sorted)

}
