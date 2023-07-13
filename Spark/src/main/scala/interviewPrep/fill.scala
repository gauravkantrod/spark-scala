package interviewPrep

import scala.collection.mutable.ListBuffer

object fill extends App{

  def fill(element:Int )(noOfTimes:Int):List[Int]={
    val l = ListBuffer[Int]()

    for(idx <- 1 to noOfTimes){
      l+=element
    }
    l.toList
  }

  val op = fill(4)(5)
  print(op)

}
