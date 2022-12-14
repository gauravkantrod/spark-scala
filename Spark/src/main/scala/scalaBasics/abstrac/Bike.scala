package scalaBasics.abstrac

class Bike extends Vehicle {
  override val b: Int = 10
  override var z: String = "ABC"


  override def vehicleType: String = "ABC"
}