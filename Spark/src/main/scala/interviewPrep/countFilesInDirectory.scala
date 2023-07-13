package interviewPrep

import java.io.File

object countFilesInDirectory extends App {

  def countFiles(dirPath:String):Option[Int]={
    val file = new File(dirPath)

    if(file.isDirectory){
      val count = file.listFiles().length
      Some(count)
    }else return None
  }

  val dirPath = "geeksforgeeks"
  val op = countFiles(dirPath).get
  println(op)
}