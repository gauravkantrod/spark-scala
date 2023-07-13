package interviewPrep


case class Employee(id:Int, email:String, salary:Salary, age:Int)
case class Salary(var basic:Double, var hra:Double,var ta:Double)

object employeeSalary extends App {

  def increase(e:Employee):Employee={
    e.salary.basic *= 1.1
    if(e.age>50) e.salary.hra *= 1.2
    e
  }


  def appraisal(emps:List[Employee]):List[Employee]={
    val op = emps.map(increase)
    op
  }

  val e1 = Employee(1,"a@gmail.com", Salary(100.0, 10.0, 10.0),25)
  val e2 = Employee(2,"b@gmail.com", Salary(300.0, 10.0, 10.0),55)
  val e3 = Employee(3,"c@gmail.com", Salary(150.0, 10.0, 10.0),40)

  val emps = List(e1,e2,e3)
  val op = appraisal(emps)
  println(op)

}
