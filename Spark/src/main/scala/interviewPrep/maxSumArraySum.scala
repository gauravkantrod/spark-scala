package interviewPrep

import scala.collection.mutable.ListBuffer

object maxSumArraySum extends App {

  def subArray(arr:Array[Int]):List[Int]={
    var maxSum = Int.MinValue
    var curSum = 0
    var startIdx = 0
    var endIdx = 0

    for(idx <- 0 until arr.length){
      curSum += arr(idx)
      if(curSum > maxSum) {
        maxSum = curSum
        endIdx = idx
      }
      else if (curSum<0) {
        curSum = 0
        startIdx = idx+1
        endIdx = 0
      }

    }

    arr.slice(startIdx, endIdx+1).toList
  }

  val arr = Array(10,20,100, 200,10,-10, 1000)
  val op = subArray(arr)
  print(op)

}
