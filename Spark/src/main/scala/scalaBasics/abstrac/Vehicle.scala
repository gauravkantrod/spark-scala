package scalaBasics.abstrac

abstract class Vehicle {

  val a = 10
  val b:Int
  var cc = 20
  var z:String

  def vehicleType:String

  def horn(): Unit = {
    println(s"pip pip..pip pip")
  }

}
