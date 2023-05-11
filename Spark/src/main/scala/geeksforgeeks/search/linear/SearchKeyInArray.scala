package geeksforgeeks.search.linear

object SearchKeyInArray extends App{

  def searchKey(arr:Array[Int], key:Int):Boolean={
    var isKeyAvailable = false
    for(ele <- arr){
      if (ele == key){
        isKeyAvailable = true
      }
    }
    isKeyAvailable
  }

  val arr = Array(1,2,3,4,5,6,7,8,99)
  println(searchKey(arr, 99))

}
