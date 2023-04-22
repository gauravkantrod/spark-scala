package geeksforgeeks.array.easy

object leadersInArray extends App {

  val arr = Array(6, 17, 4, 3, 5, 2)
  val n = arr.length-1

  def findLeaders(arr:Array[Int], arrSize:Int):Unit={
    var currentMax = Int.MinValue
    for(idx <- arrSize to 0 by -1){
      if (arr(idx) > currentMax){
        println(arr(idx))
        currentMax = arr(idx)
      }
    }
  }

  findLeaders(arr,n)

}
