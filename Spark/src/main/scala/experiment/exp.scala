package experiment

class ageException(age: String) extends Exception(age)

case class employee(name: String, exp: Int, salary: Float)

object exceptionHandlingThrow {
  @throws(classOf[ageException])
  def empValidate(exp: Int): String = {
    if (exp < 4) {
      throw new ageException(s"please try ${4 - exp} years later")
    }
    else {
      "Eligible"
    }
  }
}
// localhost
// loca1host

object mainObject {
  def main(args: Array[String]): Unit = {
    val empList = getEmployee
    val result = empList.map(emp => {
      try {
        val result = exceptionHandlingThrow.empValidate(emp.exp)
        (emp.name, result)
      } catch {
        case e: ageException => {
          println(s"not valid : ${e.getMessage}")
          (emp.name, e.getMessage)
        }
      }
    })
    result.foreach(println)
  }

  private def getEmployee: List[employee] = {
    val emp1 = employee("suraj", 5, 5000)
    val emp2 = employee("maya", 2, 3000)
    List(emp1, emp2)
  }
}
