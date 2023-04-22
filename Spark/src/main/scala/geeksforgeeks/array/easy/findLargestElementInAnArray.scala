package geeksforgeeks.array.easy

object findLargestElementInAnArray extends App {

  val lst :List[Int] = List(3,5,7,200,1,2,3,99,1)

  var (first, second, third) = (Double.NegativeInfinity, Double.NegativeInfinity, Double.NegativeInfinity)
  if (lst.length < 3){
    println(s"Length of array should be greater than or equal to 3")
  }else {
    for (ele <- lst) {
      if (ele > first) {
        third = second
        second = first
        first = ele
      } else if (ele > second) {
        third = second
        second = ele
      } else if (ele > third) {
        third = ele
      }
    }
  }

  println(s"${first}, ${second}, ${third}")

}
