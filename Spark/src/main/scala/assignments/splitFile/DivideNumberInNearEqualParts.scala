package assignments.splitFile

import scala.collection.mutable.ArrayBuffer

object DivideNumberInNearEqualParts extends App {

  def splitInNearEqualParts(elements:Int, numberOfPartitions:Int):ArrayBuffer[Int]={
    var partitionsSizes = new ArrayBuffer[Int]

    val rem = elements%numberOfPartitions
    val div = elements/numberOfPartitions // will return int

    if(elements > numberOfPartitions) {
      if (rem == 0 & div != 0) {
        partitionsSizes = ArrayBuffer.fill(numberOfPartitions)(div)
      } else if (div == 0 & rem != 0) {
        partitionsSizes = ArrayBuffer.fill(1)(rem)
      } else if (rem != 0 & div != 0) {
        partitionsSizes = ArrayBuffer.fill(numberOfPartitions)(div)
        (0 until rem).foreach(idx => partitionsSizes(idx) = partitionsSizes(idx) + 1)
      }
    }else{
      partitionsSizes = ArrayBuffer.fill(numberOfPartitions)(1)
      (elements until numberOfPartitions).foreach(idx => partitionsSizes(idx) = 0)
    }

    partitionsSizes

  }

  val elements = 76
  val numberOfPartitions = 10

  println(splitInNearEqualParts(elements, numberOfPartitions))
}