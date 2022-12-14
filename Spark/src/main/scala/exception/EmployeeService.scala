package exception

case class EmployeeService(){
  @throws[WorkExpException]
  def checkWorExp(exp:Int):String={
    val isEligible = if(exp > 4) true else false

    isEligible match {
      case true => "Eligible"
      case _ => throw WorkExpException("Work experience of candidate should be more than 4 years")
    }

  }

}
