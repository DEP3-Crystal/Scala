package optionSomeNone

object OptionSomeNone extends App {
  def convertToFloat(someString : String):Any={
    try{
      val floatVal=someString.toFloat
      floatVal
    }catch {
      case e:NumberFormatException=>null
    }
  }
  val googStockPrice=List("123.2","212.1","1231.1","asdf")

  println(googStockPrice.map(convertToFloat))

}
object OptionSomeNonee extends App {
  def convertToFloat(someString : String):Option[Float]={
    try{
      Some(someString.toFloat)
    }catch {
      case e:NumberFormatException=>None
    }
  }
  val googStockPrice=List("123.2","212.1","1231.1","asdf")

  val goog=googStockPrice.map(convertToFloat)

  for(opt<-goog) {
    opt match {
    case Some(price) =>println(price)
    case None =>println("this")
  }
  }

  for (opt <- goog) {
  println(opt.getOrElse("this"))
  }

  println(goog.map(_.getOrElse("this")))

  //println("Average price: "+(goog.sum / goog.size))
}
