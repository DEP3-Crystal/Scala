package HandelingException
import scala.io.BufferedSource
import scala.util.{Try, Success, Failure}
import scala.io.Source
object HandelingExcepion extends App {
  def getLinesFromFile(filename: String): Try[BufferedSource] = {

    Try(Source.fromFile(filename))

  }

  val trySourcePAth: Try[BufferedSource] =
    getLinesFromFile("C:\\Users\\HP\\IdeaProjects\\Scala\\src\\main\\scala\\HandelingException\\divindedStocks.csv")
//
//        trySourcePAth match{
//          case Success(sourcePath)=>sourcePath.getLines().toList.foreach(println)
//          case Failure(exception)=>println(exception.getMessage)
//        }
}
