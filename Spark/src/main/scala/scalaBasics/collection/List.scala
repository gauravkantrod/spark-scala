package scalaBasics.collection

object ListObj extends App {

  val lst = Nil
  println(lst)
  val newLst = 5 +: Nil
  val newLst2 = 6 +: Nil

  //println(Nil.hashCode())
  //println(Nil.hashCode())

  val empList = List()

  val l = List(1,2,3,4,5,6,7,8)

  val lstn = List(89,7,54,2,1,33,4)

  implicit val x = Ordering.Int.reverse
  println(lstn.sorted)
  //println(lstn.sorted(math.Ordering.Int.reverse))

  println(lstn.sortWith(_>_))

  println(lstn.sortBy(ele => ele))

//  println(lstn.sortBy(ele => ele.name))
//  println(lstn.sortBy(ele => ele.age))

  val tbList = List.tabulate(5,5)(_+_)
  println(tbList)

  // sorting custom object
  case class Person(name:String, age:Int)
  val pList = List(Person("G", 22), Person("H", 70))
  println(pList.sortBy(_.age))
  println(pList.sortBy(_.name))

//  val lst3 = List(1,2,3)
//  lst3 +: 10
//  println(lst3)


}