package interviewPrep

object arrangeBraces extends App {

  def checkSymmetry(input:String):Boolean={
    val l = input.length

    if(l%2==1) false
    else{
      val openBraces = Array('{','[','(')
      //val closedBraces = Array('}',']',')')
      var openBracesCount = 0
      var closedBracesCount = 0

      for(e <- input){
        if(openBraces.contains(e)) openBracesCount += 1
        else closedBracesCount += 1
      }

      if(openBracesCount==closedBracesCount) true
      else false
    }
  }

  val ip = "[(){()}]"
  println(checkSymmetry(ip))

}
