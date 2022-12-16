package scalaBasics

object PartiallyAppliedFunction extends App {

  def createEmployee(name: String, companyName: String, salary: Float) = {
    println(s"Employee is -- ${name}, ${companyName}, ${salary}")
  }

  val employee = createEmployee(_: String, "TCS", 300000.0F)

  employee("Gaurav")
  employee("Gauri")


}
