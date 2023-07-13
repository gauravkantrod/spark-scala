package interviewPrep

object wordCount extends App {

  def wordCount(str:String):Map[String,Int]={
    val data = str.trim.split(" ").map(_.toLowerCase).map((_,1)).groupBy(_._1).map(x => (x._1, x._2.toList.length))
    data
  }

  val s = "hello how are you hello "
  val op = wordCount(s)
  print(op)
}