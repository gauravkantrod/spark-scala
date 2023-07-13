package interviewPrep

object concatenateTwoList extends App {

  def concat(l1:List[Int], l2:List[Int]):List[Int]={
    val op = l1.foldLeft(l2){(o, e)=> e :: o}
    op
  }


  val l1 = List(1,2,3,4,5)
  val l2 = List(6,7,8,9)

  val op = concat(l1, l2)
  print(op)

}
