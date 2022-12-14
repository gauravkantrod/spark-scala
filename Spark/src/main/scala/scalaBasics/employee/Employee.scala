package scalaBasics.employee


case class Employee(id: Int, var name: String, dob: String, address: Address){
  def sayHello(name:String)={
    println(s"Hello, ${name}")
  }
}
