package interviewPrep

object reverseFoldLeft extends App {

  val l = List(1,2,3,4,5,6)
  val op = l.foldLeft(List[Int]()){(x,y) => y::x}
  println(op)


  def reverseList(orgList:List[Int], revList:List[Int]):List[Int]={
    val op = orgList match {
      case Nil => revList
      case head::tail => reverseList(tail, head::revList)
    }
    op
  }

  val op2 = reverseList(l, List())
  println(op2)
}
