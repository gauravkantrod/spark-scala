package scalaBasics.collection

object CustomListSorting extends App {

  case class Person(name:String, age:Int, salary:Int)
  val personList = List(
    Person("A", 22, 1000),
    Person("B", 10, 4000),
    Person("C", 32, 3000),
    Person("D", 12, 2000),
    Person("E", 82, 100000)
  )

  implicit val revSort = math.Ordering.Int.reverse
  //implicit val revNameSort = math.Ordering.String.reverse
//  println(personList.sortBy(_.age))
//  println(personList.sortBy(_.name))

//  println(personList.sortWith(_.age > _.age))
//  println(personList.sortWith(_.age < _.age))
//  println(personList.sortWith(_.name > _.name))


  case class Person2(name:String, age:Int, salary:Int) extends Ordered[Person2]{

    override def compare(p: Person2): Int = {
      if (this.age == p.age) 0
      else if(this.age > p.age) 1
      else -1
    }
  }

  val personList2 = List(
    Person2("A", 22, 1000),
    Person2("B", 10, 4000),
    Person2("C", 32, 3000),
    Person2("D", 12, 2000),
    Person2("E", 82, 100000)
  )

  println(personList2.sorted)

  
}