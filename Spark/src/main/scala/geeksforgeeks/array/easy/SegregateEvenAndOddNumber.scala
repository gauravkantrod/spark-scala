package geeksforgeeks.array.easy

import scala.collection.mutable.ArrayBuffer

object SegregateEvenAndOddNumber extends App {

  var lst = ArrayBuffer(1,2,3,4,5,6,7,8)

  var start_idx = 0
  var end_idx = lst.length-1

  while (start_idx < end_idx){
    if(lst(start_idx)%2==0){
      start_idx += 1
    }else if (lst(end_idx)%2==1){
      end_idx -= 1
    }else if (lst(start_idx)%2==1 && lst(end_idx) %2 == 0){
      val odd_ele = lst(start_idx)
      lst(start_idx) = lst(end_idx)
      lst(end_idx) = odd_ele
    }
  }

  println(lst)

}
