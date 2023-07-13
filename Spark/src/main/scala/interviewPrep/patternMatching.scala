package interviewPrep

object patternMatching extends App{

//  val op = 5 match {
//    case x:Double => x+1
//    case _ => 0
//  }
//  println(op)


  val l = List(1,2,3,4,5,6)
//  val op = l.foldLeft(0){(x,y) => x+y}
//  println(op)

//  val op2 = l.foldLeft(List[Int]()){(x,y) => y::x}
//  println(op2)

//  val l1 = List(2,3)
//  val l2 = List(9,8)
//  print(5 :: l1)


//  def reverseList(orgList:List[Int], revList:List[Int]):List[Int]={
//    val op = orgList match {
//      case Nil => revList
//      case head::tail => reverseList(tail, head::revList)
//    }
//    op
//  }
//
//  println(reverseList(l, List()))

  val arr = Array(1,2,3,4,5,6)
  val p1 = arr.slice(0,3).toList
  println(arr.slice(0,3).toList)
}