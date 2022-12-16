package collection

object Immutable extends App {

  val immutableList_1 = List(1,2,3,4,5,6)
  println(immutableList_1)

  // immutableList_1 += 9 // wont work as immutableList_1 is val

  val immutableList_2 = List(1,2,3,4,5,6)
  println(immutableList_2)

  val newLst = immutableList_2 :+ 5 // + on the side of the element needs to be appended to the immutable list
  println(newLst)

  val newLst2 = 10 +: immutableList_2 // prepend
  println(newLst2)

  val cnt = newLst2.count(_%2==0)
  println(cnt)

  val diffList = newLst2.diff(newLst)
  println(diffList)




}