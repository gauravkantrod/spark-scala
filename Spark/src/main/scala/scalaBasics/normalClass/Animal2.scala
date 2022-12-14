package scalaBasics.normalClass

class Animal2(val name:String, val age:Int) {
  println("Primary constructor")

  def this()={
    this("", 1)
    println("In secondary constructor")
  }

}
