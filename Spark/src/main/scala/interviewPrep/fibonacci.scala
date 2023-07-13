package interviewPrep

object fibonacci extends App {

  def calFibonacciList(n: Int): List[Int] = {
    var firstNum = 0
    var secondNum = 1
    val fibonacciList = scala.collection.mutable.ListBuffer[Int]()

    if(n==0) return fibonacciList.toList
    else if(n==1) fibonacciList += 1
    else{
      fibonacciList += 1
      for (idx <- 0 until (n - 1)) {
        val nextNum = firstNum + secondNum
        firstNum = secondNum
        secondNum = nextNum
        fibonacciList += nextNum
      }
    }
    fibonacciList.toList
  }

  println(calFibonacciList(1))
}