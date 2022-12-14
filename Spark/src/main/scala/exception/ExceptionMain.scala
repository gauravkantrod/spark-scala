package exception

object ExceptionMain extends App {

  val empList = List(Employee("Gaurav", 28, 5), Employee("Anita", 28, 3))
  val empService = new EmployeeService

  empList.foreach(emp => {
    try{
      val eligibility = empService.checkWorExp(emp.exp)
      println(s"${emp.name} is eligible for job.")
    }
    catch {
      case e:WorkExpException => println(s"${emp.name} is not eligible for job -- ${e.getMessage}")
      case e:Exception => println(e.getMessage)
    }
  })
}