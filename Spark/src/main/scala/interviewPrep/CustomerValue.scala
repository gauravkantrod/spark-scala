package interviewPrep

case class Customer(value: Int)
case class Consultant(portfolio: List[Customer])
case class Branch(consultants: List[Consultant])
case class Company(branches: List[Branch])

object CustomerValue extends App {

  def getCompanyValue(company: Company): Int = {

    val valuesList: List[Int] = for (branch <- company.branches; consultants <- branch.consultants; customer <- consultants.portfolio)
      yield {
        customer.value
      }

    valuesList.reduce(_ + _)

  }

  val customer1 = Customer(10)
  val customerList1 = List(customer1)

  val customer2 = Customer(10)
  val customerList2 = List(customer2)

  val customer3 = Customer(10)
  val customerList3 = List(customer3)

  val customer4 = Customer(10)
  val customerList4 = List(customer4)

  val consultant1 = Consultant(customerList1)
  val consultant2 = Consultant(customerList2)
  val consultant3 = Consultant(customerList3)
  val consultant4 = Consultant(customerList4)

  val consultantList1 = List(consultant1, consultant2)
  val consultantList2 = List(consultant3, consultant4)

  val branch1 = Branch(consultantList1)
  val branch2 = Branch(consultantList2)

  val branchList = List(branch1, branch2)

  val company = Company(branchList)

  val op = getCompanyValue(company)
  println(op)

}