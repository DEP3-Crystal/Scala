package TrySuccessFaliure
import java.io.{BufferedReader, FileReader}
import scala.util.{Failure, Success, Try, Using}

object SucessFaliure extends App {
var lines:Try[List[String]]=
  Using(new BufferedReader(new FileReader(
    "C:\\Users\\HP\\IdeaProjects\\Scala\\src\\main\\scala\\TrySuccessFaliure\\divindedStocks.csv"
  ))){
    reader=>Iterator.continually(reader.readLine()).takeWhile(_!=null).toList
  }

//  lines match
//     {
//    case Success(lines)=>lines.foreach(println)
//    case Failure(exception)=>exception.getMessage
//
//}
}
