package interviewPrep

import scala.collection.mutable.ListBuffer

case class Student(id:Int, name:String, age:Int, branch:String)

object students extends App {

  def spiltByBranch(list:List[Student]):(List[Student],List[Student],List[Student],List[Student])={
    val cs = ListBuffer[Student]()
    val it = ListBuffer[Student]()
    val ec = ListBuffer[Student]()
    val me = ListBuffer[Student]()

    for(s <- list){
      if(s.branch == "CS") cs += s
      else if (s.branch == "IT") it += s
      else if (s.branch == "EC") ec += s
      else me += s
    }
    (cs.toList, it.toList, ec.toList, me.toList)
  }

  val s1 = Student(1, "A", 12, "CS")
  val s2 = Student(2, "B", 12, "IT")
  val s3 = Student(3, "C", 12, "EC")
  val s4 = Student(4, "D", 12, "ME")
  val s5 = Student(5, "E", 12, "CS")
  val s6 = Student(6, "F", 12, "IT")

  val studentsList = List(s1,s2,s3,s4,s5,s6)
  val (cs, it, ec, me) = spiltByBranch(studentsList)
  println(cs, it, ec, me)
}