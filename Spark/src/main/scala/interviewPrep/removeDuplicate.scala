package interviewPrep

object removeDuplicate extends App {

  def dedupe(list:List[Int]):List[Int]= {

    val op = list.foldLeft(List[Int]()){(o,x) => if(!o.contains(x)) x::o else o }

    op
  }

  val l = List(1,1,2,2,3,3,4,4,5,5)
  val op = dedupe(l)
  println(op)
}