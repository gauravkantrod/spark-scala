package scalaBasics

object PartialFunction extends App {

  def square:PartialFunction[Int, Int] = new PartialFunction[Int, Int]{
    override def apply(x: Int): Int = x*x

    override def isDefinedAt(x: Int): Boolean = x != 0
  }

  // is unary i.e takes only one single input and gives one single output
  val square2 :PartialFunction[Int, Int]={
    case x if(x>0) => x*x
  }


  println(square(0))
}