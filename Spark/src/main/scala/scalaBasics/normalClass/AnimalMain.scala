package scalaBasics.normalClass

object AnimalMain extends App {

  val a1 = new Animal1() // new required as Animal1 doesn't have a parameterized constructor
  //println(a1)
  a1.name = "Nanu"
  a1.age = 10
  //println(a1.toString)

  println()
  val a2 = new Animal2()

  println()
  val a3 = new Animal2("GAK", 22)

  println()
  val a4 = new Animal2("GAK", 22)
}