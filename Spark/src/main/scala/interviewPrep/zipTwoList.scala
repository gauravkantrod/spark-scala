package interviewPrep

object zipTwoList extends App {

  def zip(l1:List[Int], l2:List[String]):List[(Int,String)]={

    val len1 = l1.length
    val len2 = l2.length

    var i = -1
    if(len1<=len2){

      l1.foldLeft(List[(Int, String)]()){
        (o, e) => i+=1; (e,l2(i)) :: o
      }
    }else{
      l2.foldLeft(List[(Int, String)]()){
        (o, e) => i+=1; (l1(i), e) :: o
      }
    }

  }


  val l1 = List(1,2,3,4,4,5,6)
  val l2 = List("one", "two", "three", "four")
  val op = zip(l1,l2)
  print(op)




}
