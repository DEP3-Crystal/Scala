package TrySuccessFaliure
import java.io.{BufferedReader, FileReader}
import scala.io.StdIn
import scala.util.Try
import scala.util.{Failure, Success, Try, Using}

object TrySucessFaliure extends App {

  def readCSVFile(filePath:String):Seq[DividendREcord]={
    val source=io.Source.fromFile(filePath)

    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",")
    }yield
      DividendREcord(
        cols(0),
        cols(1),
        cols(2).toFloat,
        cols(3).toFloat,
      )
  }
  val records=readCSVFile("C:\\Users\\HP\\IdeaProjects\\Scala\\src\\main\\scala\\TrySuccessFaliure\\divindedStocks.csv")

  @scala.annotation.tailrec
  def calculateDivindedYield():Try[Double]={
    val ticker=StdIn.readLine("Enter ticker")

    val currentPrice=Try(StdIn.readLine("Enter current price").toDouble)

    val faceValue:Try[Double]=Try(
      records.filter(_.ticker==ticker).map(_.face_value).head.toDouble)

    val dividentRate:Try[Double]=Try(
      records.filter(_.ticker==ticker).map(_.divident).head*0.01)

    val divindedPerShare:Try[Double]=faceValue.flatMap(
        fv=>dividentRate.map(divRate=>fv*divRate))

    val dividentYield:Try[Double]=divindedPerShare.flatMap(
      divPerShare=>currentPrice.map(currentPrice=>divPerShare/currentPrice*100))

    dividentYield match{
      case Success(divYield)=>
        println(s"Divident yield of $ticker is: ${divYield}%")
        Success(divYield)
      case Failure(exception)=>
        println("----"+exception.getMessage)
        println("An error occurred along the way, try again!")
        calculateDivindedYield()
    }
  }
  calculateDivindedYield()


}
