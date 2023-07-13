package geeksforgeeks.sorting

object Selection extends App {

  def selectionSort(arr: Array[Int]): List[Int] = {
    for (idx1 <- 0 to (arr.length - 1)) {
      var min_idx = idx1

      for (idx2 <- idx1 + 1 to (arr.length - 1)) {
        if (arr(idx2) < arr(min_idx)) {
          min_idx = idx2
        }
      }
      val temp = arr(min_idx) // minimum value
      arr(min_idx) = arr(idx1)
      arr(idx1) = temp
    }
    arr.toList
  }


  var arr = Array(19,22,43,2,20,4,9,88,19)
  val sortedArr = selectionSort(arr)
  println(sortedArr)
}