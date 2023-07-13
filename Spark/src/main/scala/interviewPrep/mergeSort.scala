package interviewPrep

object mergeSort extends App{

  // Time complexity O(n) where n>m, space complexity O(n) where n>m
  def mergeTwoSortedArray(arr1:Array[Int], arr2:Array[Int]):List[Int]={
    var idx1 = 0
    var idx2 = 0
    val arr1Len = arr1.length
    val arr2Len = arr2.length
    //var idxFinal = 0
    //val totalLen = arr1.length + arr2.length
    val mergedList = scala.collection.mutable.ListBuffer[Int]()

    while((idx1 < arr1Len) && (idx2 < arr2Len)){
      if(arr1(idx1)<=arr2(idx2)){
        mergedList += arr1(idx1)
        idx1 += 1
      }else{
        mergedList += arr2(idx2)
        idx2 += 1
      }
      //idxFinal += 1
    }
    if(idx1<arr1Len){
      for(i <- idx1 until(arr1Len)){
        mergedList += arr1(i)
      }
    }else if(idx2 < arr2Len){
      for (j <- idx2 until(arr2Len)){
        mergedList += arr2(j)
      }
    }
    mergedList.toList
  }

//  val arr1 = Array(1,3,5,7,9)
//  val arr2 = Array(2,4,6,8,10)
//  val mergedSortedArray = mergeTwoSortedArray(arr1, arr2)
//  println(mergedSortedArray)

//  def mergeSort(arr:Array[Int], leftIdx:Int, rightIdx:Int):Array[Int]={
//
//    if(leftIdx < rightIdx){
//      val mid = (leftIdx+rightIdx)/2
//    }
//
//  }



  val arr = Array(1,9,10,22,43,2,2,5)
//  println(mergeSort(arr))

}
