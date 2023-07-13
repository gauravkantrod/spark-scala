package interviewPrep

object removeListedKeys extends App {

  def removeKeys( keys:List[String], map:Map[String, Int]):Map[String,Int]={
    val op = map.filter(d => !keys.contains(d._1))
    op
  }

  val keys = List[String]("A", "B", "C", "D")
  val map2 = Map[String, Int]("A" -> 1, "B" -> 2, "C" -> 3, "D" -> 4, "E"->5, "F"->6, "G"->7)
  val op =removeKeys(keys, map2)
  println(op)

}
