package assignments

import java.io.File
import scala.collection.SortedMap
import scala.collection.mutable.ListBuffer
import scala.io.Source

object StateDistrictSortingMap extends App {

  val BASE_PATH = "/Users/gauravkantrod/Desktop/BigData/olc/scala/StateDistrictSorting/"

  def getFiles(dir:String):List[File]={
    val d = new File(dir)
    if(d.isDirectory){
      d.listFiles().filter(_.isFile).toList
    }else{
      List[File]()
    }
  }

  val fileLocation = getFiles(BASE_PATH)
  println(fileLocation)

  var sortedTreeMap = SortedMap[String, ListBuffer[String]]()
  fileLocation.foreach(path =>{
    val stateName = path.getName.split("\\.")(0)
    println(stateName)
    val file = Source.fromFile(path)
    val listBuffer = new ListBuffer[String]()
    file.getLines().foreach(line => listBuffer += line)

    sortedTreeMap += (stateName-> listBuffer.sortWith(_>_))
  })

  //println(sortedTreeMap)
  println(sortedTreeMap.toSeq.sortWith(_._1 > _._1).toMap)

}