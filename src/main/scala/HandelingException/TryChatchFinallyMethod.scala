package HandelingException

import java.io.FileNotFoundException
import scala.io.{BufferedSource, Source}

object TryChatchFinallyMethod extends App {
  def getLinesFromFile(filename:String):List[String]={
    var sourcePathh:BufferedSource = null
    try{
      sourcePathh=Source.fromFile(filename)
      println("Reading file completed")
      sourcePathh.getLines().toList
    }catch {
      case ex:FileNotFoundException=>{
        println("File not Found")
        List()
      }
    }finally {
      println("Close file if it has benn opened")
      if(sourcePathh!=null){
        println("closing file")
        sourcePathh.close
      }
      List("this","list","dont","invoke")
    }

  }
  val lines=getLinesFromFile("C:\\Users\\HP\\IdeaProjects\\Scala\\src\\main\\scala\\HandelingException\\divindedStocks.csv")
  lines.foreach(println)
}
