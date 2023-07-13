package geeksforgeeks.sorting

object Bubble extends App{

  def bubbleSort(arr:Array[Int]):List[Int]={

    for(idx1 <- 0 until  arr.length-1){
      for (idx2 <- 0 until  arr.length-1-idx1){
        if(arr(idx2) > arr(idx2+1)){
          val temp = arr(idx2+1)
          arr(idx2+1) = arr(idx2)
          arr(idx2) = temp
        }
      }
    }
    arr.toList
  }


  var arr = Array(10,20,3,2,5,99,7)
  println(bubbleSort(arr))

}
