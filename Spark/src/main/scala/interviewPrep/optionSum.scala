package interviewPrep

object optionSum extends App {

  def sum( opt1:Option[Int],opt2: Option[Int]):Option[Int]={
    val op = opt1.getOrElse(0) + opt2.getOrElse(0)
    Option(op)
  }

  val num1: Option[Int] = Some(2)
  val num2: Option[Int] = None

  val res = sum(num1, num2)
  println(res.get)
}