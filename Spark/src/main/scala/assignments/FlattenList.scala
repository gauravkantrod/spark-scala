package assignments

object FlattenList extends App {

  val lst = List(1,
    List(2,3),
    List(List(4,5,6), 7,8,9),
    10,
    List(11, List(12,13))
  )

  def flattenList(lst:List[Any]):List[Any]={
    lst.flatMap{
      case x:List[_] => flattenList(x)
      case x:Int => List(x)
    }
  }

  println(flattenList(lst))

}