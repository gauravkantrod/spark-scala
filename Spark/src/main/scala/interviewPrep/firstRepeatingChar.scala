package interviewPrep

object firstRepeatingChar extends App {

  def findFirstRepeatingChar(arr: Array[Char]): Option[Char]= {
    for (idx <- 0 to arr.length - 2) {
      if (arr(idx).toLower == arr(idx + 1).toLower) {
        return Some(arr(idx).toLower)
      }
    }
    None
  }

  val arr = Array('a','z','B', 'd', 'C', 'd', 'D')
  println(findFirstRepeatingChar(arr).get)

}
