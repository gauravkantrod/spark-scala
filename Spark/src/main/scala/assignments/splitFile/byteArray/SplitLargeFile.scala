package assignments.splitFile.byteArray

import java.io.FileInputStream
import scala.io.{Codec, Source}

object SplitLargeFile extends App {

  val LARGE_FILE_PATH = "/Users/gauravkantrod/Downloads/Rocketry-the-nambi-effect.mkv"

  implicit val codec = Codec("UTF-8")
//  val file = Source.fromFile(LARGE_FILE_PATH)
//  println(file.size)

}
