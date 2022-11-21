package HandelingException

import java.io.FileNotFoundException
import scala.io.BufferedSource

object TryChatchFinally extends App {
 var sourcePath:BufferedSource = _
  try{
     sourcePath = io.Source.fromFile("C:\\Users\\HP\\IdeaProjects\\Scala\\src\\main\\scala\\HandelingException\\divindedStocks.csv")

    val list = sourcePath.getLines().toList
    println(list)
  }catch {

   case ex: FileNotFoundException => {
      println("vrk")
    }
   case ex:IndexOutOfBoundsException=>{
     println("vk")
   }
  }finally {
    println("Close file if it has been opened")
    if(sourcePath!=null){
      println("Closing file")
      sourcePath.close()
    }
  }
  println("---------------")






}
