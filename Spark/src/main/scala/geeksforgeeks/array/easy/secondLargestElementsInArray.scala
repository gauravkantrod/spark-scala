package geeksforgeeks.array.easy

object secondLargestElementInArray extends App {

  val lst :List[Int] = List(3,444,5,7,200,1,2,3,99,1)
  var (first, second) = (Double.NegativeInfinity, Double.NegativeInfinity)

  for (ele <- lst){
    if (ele > first){
      second = first
      first = ele
    }else if (ele > second){
      second = ele
    }
  }

  println(s"${first}, ${second}")
}