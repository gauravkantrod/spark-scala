package SerializationDeserialization

import org.apache.commons.lang3.SerializationUtils

import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}

object EmployeeSerDe extends App{

  def serializer(e:Employee)={
    val fos = new FileOutputStream("/Users/gauravkantrod/Desktop/BigData/olc/scala/SerDe/emp.ser")
    val oos = new ObjectOutputStream(fos)

    oos.writeObject(e)
    oos.close()
  }

  def deserializer(path: String): Employee = {
    val ois = new ObjectInputStream(new FileInputStream(path))
    val emp = ois.readObject().asInstanceOf[Employee]
    emp
  }

  val emp = Employee("Gaurav", 28)
//  serializer(emp)
//  println(deserializer("/Users/gauravkantrod/Desktop/BigData/olc/scala/SerDe/emp.ser"))

  def getEmpByteArray(e:Employee)={
    val empbyteArray = SerializationUtils.serialize(e)
    empbyteArray
  }

  def getObjectFromByteArray(empByteArray:Array[Byte])={
    val empObj = SerializationUtils.deserialize[Employee](empByteArray)
    empObj
  }

  println(getObjectFromByteArray(getEmpByteArray(emp)))
}