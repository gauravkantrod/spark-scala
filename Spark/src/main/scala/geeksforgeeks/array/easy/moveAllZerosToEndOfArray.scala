package geeksforgeeks.array.easy

import scala.collection.mutable.ListBuffer

object moveAllZerosToEndOfArray extends App {
  val lst = ListBuffer(1, 2, 0, 4, 3, 0, 5, 0)

  var start_idx = 0
  var end_idx = lst.length-1

  while (start_idx < end_idx){
    if (lst(start_idx) != 0){
      start_idx += 1
    }else if (lst(end_idx) == 0){
      end_idx -= 1
    }else if (lst(start_idx) == 0 && lst(end_idx) != 0){
      lst(start_idx) = lst(end_idx)
      lst(end_idx) = 0
    }
  }

  println(lst)

}
