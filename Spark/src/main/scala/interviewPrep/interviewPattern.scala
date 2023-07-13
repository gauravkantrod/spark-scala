package interviewPrep

import scala.collection.mutable.ListBuffer

object interviewPattern extends App {
  def findAllPrimeNumbers(num:Int):ListBuffer[Int]={
    val primeList:ListBuffer[Int] = ListBuffer()
    if(num==0 || num==1) primeList
    else if (num==2) primeList.append(2)
    else{
      primeList.append(2)
      for(num <- 3 to num){
        var isPrime = true
        for(e <- 2 to Math.sqrt(num).toInt+1){
          if(num%e==0){
            isPrime = false
          }
        }
        if (isPrime){
          primeList.append(num)
        }
      }
    }
    primeList
  }

  val primeOp = findAllPrimeNumbers(1)
  println(primeOp.indexOf(1)+1)
}