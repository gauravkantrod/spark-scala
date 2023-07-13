package interviewPrep

class RegistrationQuerySystem(queryInput:String){

  def queryRegistration(carRegistrationNumber:String):Unit = {
    val carStateAndDistrict = carRegistrationNumber.trim.slice(0,5)
    val carState = carRegistrationNumber.trim.slice(0,2)

    val data = queryInput.split("\n")
    var addressMap = scala.collection.immutable.Map[String, String]("MH" -> "Maharashtra registered",
      "KA" -> "Karnataka registered")

    for (e <- data) {
      val len = e.length
      val key = e.trim.slice(0, 5).replace("-", " ")
      val value = e.trim.slice(6, len) +" registered"
      addressMap += (key -> value)
    }

    if (addressMap.contains(carStateAndDistrict)){
      println(s"${addressMap(carStateAndDistrict)}")
    }else if(addressMap.contains(carState)){
      println(s"${addressMap(carState)}")
    }else{
      println(s"Unknown registration")
    }
  }



}

object main extends App{
  val obj = new RegistrationQuerySystem("MH-01,Maharastra,Fort Area RTO\n " +
    "MH-43,Maharastra,Vashi RTO\n MH-05,Maharastra,Pune RTO\n " +
    "KA-51,Karnatka, Electronic City RTO")

  obj.queryRegistration("XY 21 DF 2456")
}
