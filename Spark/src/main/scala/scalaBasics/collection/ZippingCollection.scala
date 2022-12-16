package scalaBasics.collection

object ZippingCollection extends App {

  val lst1 = List(10,20,30)
  val lst2 = List(70,80,90)
  val lst3 = List("Gaurav", "ajay", "Bijay")

  println(lst1.zip(lst2))

  val zippedLst = lst1.zipWithIndex.map({ // iterableOnceOps
    case (num, idx) => println(s"$num, $idx")
  })

  println(lst1.zip(lst2).zip(lst3))
  val pList = List(lst1, lst2, lst3)
  println(pList.transpose)


}