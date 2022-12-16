package assignments

object ReduceFoldetc extends App {
  val lst = List(10,20,30,40,10,20,30,200)

  val sum = lst.reduce(_+_)
  val sum2 = lst.reduceLeft((acc, i) =>{
    println(acc, i)
    acc + i
  })
  println(sum2)

  val sum3 = lst.reduceRight((i,acc) =>{
    println(acc, i)
    acc + i
  })
  println(sum3)

  val lst2 = List(List(1,2), List(3,4), List(5,6))
  val op1 = lst2.flatten.map(_+1)
  println(op1)
  op1.sliding(2, 2).foreach(println)


  // head, headOption
  // tail, tailOption
  // last
}