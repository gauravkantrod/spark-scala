package scalaBasics.employee
object EmployeeMain extends App {

  val address = Address(100, "Khustadham road", "Savedi", "Ahmednagar", "MH", 414001)
  val employee = Employee(101, "Gaurav", "09/10/1994", address)

  println(employee)
  println(employee.address)
  println("Done")
}