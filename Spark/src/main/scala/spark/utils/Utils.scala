package spark.utils

object Utils extends App {

  def getUniqueInt(s:String):Int={
    val numsSeq = s.zipWithIndex.map{case(c, idx)=>
      c.toInt * math.pow(10, idx)
    }
    numsSeq.reduce(_+_).toInt
  }

  println(getUniqueInt("GAURAV"))
  println(getUniqueInt("URAVGA"))

}
