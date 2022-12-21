package scalaBasics.collection

object MapCollection extends App {
  // Immutable Map
  var m1 = Map[Int, String]()
  val m2 = Map()

  m1 += (1 -> "Z")
  println(m1)

  // Mutable Map, //HashMap
  val map = scala.collection.mutable.Map[Int, String]()
  map += (1 -> "Z")
  map += (2 -> "Y")
  map += (3 -> "X")
  println(map)
  println(map.getOrElse(2, "Not found"))
  println(map.getOrElse(10, "Not found"))

  println(map.mapValuesInPlace((k,v)=> if(k %2 == 0) "Even" else "Odd"))

}
