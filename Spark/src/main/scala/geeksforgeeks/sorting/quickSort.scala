package geeksforgeeks.sorting

object quickSort extends App {

  def swap(arr:Array[Int], index1:Int, index2:Int):Array[Int]={
    val temp = arr(index1)
    arr(index1) = arr(index2)
    arr(index2) = temp
    arr
  }

//  def partitioningIndex(arr:Array[Int], start:Int, end:Int):Int={
//    var pivot = arr(0)
//    var start_idx = start
//    var end_idx = end
//
//    while(start_idx < end_idx){
//      if(arr(start) > pivot){
//        start_idx += 1
//      }
//      if (arr(end_idx) < pivot){
//        end_idx -= 1
//      }
//    }
//    0
//  }


  var arr = Array(1,4,6,8,2,4,9,5)
  println(swap(arr, 2,7))
//  val pIndex = partitioningIndex(arr, 1, arr.length-1)
//  println(s"partitioning index is -- ${pIndex}")
}
