package scalaBasics

object FunctionalProgramming extends App {

  def sayHello(): Unit = {
    println("Hello")
  }

  def executeMe_1(fun1: () => Unit): Unit = {
    fun1()
  }

  //executeMe_1(sayHello)
  def double(num: Int): Int = {
    num * 2
  }

  def executeMe_2(fun: (Int) => Int): Int = {
    val op = fun(10)
    println(op)
    op
  }

  //executeMe_2(double)

  val double2 = (num: Int) => num * 2


  def even(num: Int): Boolean = {
    num % 2 == 0
  }

  val evenAny = (num: Int) => num % 2 == 0

  def executeMe_3(fun: (Int, Int) => Float): Float = {
    val op = fun(10, 20)
    println(op)
    op
  }

  def divide(num1: Int, num2: Int): Float = {
    num1 / num2.toFloat
  }

  //executeMe_3(divide)

  def calculator(fun: (Int, Int) => Float, num1: Int, num2: Int): Float = {
    val op = fun(num1, num2)
    op
  }

  println(calculator(divide, 10, 5))
}
