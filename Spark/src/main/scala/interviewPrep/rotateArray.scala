package interviewPrep

object rotateArray extends App{

  def rotate(a:Array[Int], r:Int):Array[Int]={
    val len = a.length
    val rem = r%len
    if(rem == 0) a
    else{
      val sliceIndex = len-rem
      val partOneArray = a.slice(sliceIndex, len)
      val partTwoArray = a.slice(0,sliceIndex)

      val op = partOneArray.concat(partTwoArray)
      op
    }
  }

  val arr = Array(1,2,3,4,5,6)
  val op = rotate(arr, 2)
  op.foreach(println)
}