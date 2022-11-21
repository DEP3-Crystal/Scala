package eitherRightLeft

object EitherRightLeft extends App {
  def convertToFloat(someString:String):Either[String,Float]={
    try{
      Right(someString.toFloat)
    }catch {
      case e:NumberFormatException=>
        Left("There was an error parsing the float: "+someString)
    }
  }
  val googStockPrice=List("123.2","212.1","1231.1","asdf")

  println(googStockPrice.map(convertToFloat))
}
