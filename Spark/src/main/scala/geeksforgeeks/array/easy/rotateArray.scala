package geeksforgeeks.array.easy

import scala.collection.mutable.ArrayBuffer

object rotateArray extends App {

  var lst = ArrayBuffer(1, 3, 5, 7, 9)
  val rotation_index = 6 // rotating index
  var start_idx = -1

  if (rotation_index < lst.size){
    start_idx = rotation_index
  }else{
    start_idx = rotation_index%lst.length
  }

  println(start_idx)
}