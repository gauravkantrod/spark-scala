package assignments

object RemoveDuplicates extends App {

  val lst1 = List(1,2,3,4,1,2)
  val lst2 = List(0,9,1,2,5,6,7)

  println(lst1.diff(lst2))
}