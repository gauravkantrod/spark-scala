package assignments.partialFunction

object EmployeePartialFunc extends App {

  case class Employee(name: String, dept: String, title: String, var salary: Float)

  val empList = List(
    Employee("GAK", "IT", "CSE", 10000F),
    Employee("Isha", "IT", "SE", 10000F),
    Employee("Suraz", "IT", "TL", 10000F),
    Employee("Ayesha", "IT", "MGR", 10000F),

    Employee("Tas", "MGMT", "HR", 10000F),
    Employee("Bholu", "MGMT", "MGR", 10000F)
  )

  val empHike: PartialFunction[Employee, Employee] = {
    case emp if (emp.title == "SE") => emp.salary = emp.salary * 1.1F; emp
    case emp if (emp.title == "TL") => emp.salary = emp.salary * 1.05F; emp
    case emp if (emp.title == "MGR") => emp.salary = emp.salary * 1.02F; emp
    case emp if (emp.title == "HR") => emp.salary = emp.salary * 1.03F; emp
    case x: Employee => x
  }

  val op = empList.map(empHike)
  println(op)


}
