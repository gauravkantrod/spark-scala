package geeksforgeeks.array.easy

import geeksforgeeks.array.easy.subArraySum.currentSum

object subArraySum extends App{

  def findTargetSum(lst:Array[Int], left:Int, right:Int, targetSum :Int,
                    currentTotal:Int, n:Int):Boolean={
    var right_idx = right
    var left_idx = left
    var currentSum = currentTotal
    var isFound = false
    while(right_idx < n){
      if(currentSum == targetSum){
        right_idx = n
        isFound = true
      }else if (currentSum < targetSum) {
        currentSum += lst(right_idx)
        right_idx += 1
      }else if (currentSum > targetSum) {
        currentSum -= lst(left_idx)
        left_idx += 1
      }
    }
    isFound
  }

  val lst = Array(1, 4, 20, 3, 10, 5)
  val targetSum = 33
  var left_idx = 0
  var right_idx = 0
  var currentSum = 0
  val n = lst.length

  println(findTargetSum(lst, left_idx,right_idx,targetSum, currentSum, n))


}