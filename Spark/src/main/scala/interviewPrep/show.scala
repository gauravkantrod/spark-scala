package interviewPrep

object show extends App {

  def show(f: Int, n: Int): List[Int] = {
    val lst = scala.collection.mutable.ListBuffer[List[Int]]()
    for (i <- 1 to n) {
      lst += List.fill(f)(i)
    }
    lst.flatten.toList
  }

  val f= 3
  val n=4
  show(f,n)

}