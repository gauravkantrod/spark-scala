package geeksforgeeks.search.binary

object binarySearch extends App {

  def binarySearch(arr:Array[Int], key:Int):Boolean= {
    var startIdx = 0
    var endIdx = arr.length-1

    while(startIdx<=endIdx){
      val middleIdx = (startIdx+endIdx)/2

      if(arr(middleIdx) == key){
        return true
      }else if(arr(middleIdx) < key){
        startIdx = middleIdx+1
      }else if (key < arr(middleIdx)){
        endIdx = middleIdx-1
      }
  }
    false
}

  val arr = Array(10,20,30,40,50,60,70,80)

  println(binarySearch(arr, 300))
}
