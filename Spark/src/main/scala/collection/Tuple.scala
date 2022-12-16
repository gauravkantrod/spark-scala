package collection

object Tuple extends App {

  val t = ("G",22,300000)
  println(t)

  val (name, age, salary) = ("G", 22, 3000)
  // name = "B" // compile time error
  var (name1, age2, salary3) = ("G", 22, 3000)
  name1 = "Z"



}
