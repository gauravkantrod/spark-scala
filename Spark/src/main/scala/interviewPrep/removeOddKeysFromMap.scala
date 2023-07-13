package interviewPrep

object removeOddKeysFromMap extends App {

  def removeOdd(map:Map[String, Int]):Map[String, Int]={
    val op = map.filter(d => d._1.toInt%2==0)
    op
  }

  val m = Map[String, Int]("1" -> 1, "2"->2,"3"->3,"4"->4,"5"->5)
  val op = removeOdd(m)
  println(op)

}