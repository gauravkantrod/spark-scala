package scalaBasics.recursion

import scala.annotation.tailrec

object FactorialRecursion extends App {

  @tailrec
  def tailRecursionFactorial(num:Int, acc:Int=1):Int={
    if(num == 1) acc
    else tailRecursionFactorial(num-1, num*acc)
  }

  println(tailRecursionFactorial(5))

}
