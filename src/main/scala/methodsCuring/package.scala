package methodsCuring
object Curring extends App {

  val readFromFile = () => {
    val source = io.Source.fromFile("C:\\Users\\HP\\IdeaProjects\\Scala\\src\\main\\scala\\ComplexOperator\\stockRecord")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)

    }yield StockRecorddd(
      cols(0),
      cols(1).toFloat,
      cols(2).toFloat,
      cols(3).toFloat,
      cols(4).toFloat,
      cols(5)
    )
  }
  val record=readFromFile();

  def getPrice(date:String,company:String,priceType:String):Float={
    val recordsByDate=record.filter(_.date==date)
    val recordByCompany=recordsByDate.filter(_.company==company)

    val price=priceType match{
      case "open" => recordByCompany(0).open
      case "close" => recordByCompany(0).close
      case "high" => recordByCompany(0).hight
      case "low" => recordByCompany(0).low
    }
    price
  }
 // record.foreach(i=>println(i))
  //println(getPrice("12,06,2020","GOOG","open"))

  def getPriceWithPlaceHolder(date: String)( company: String)( priceType: String): Float = {
    val recordsByDate = record.filter(_.date == date)
    val recordByCompany = recordsByDate.filter(_.company == company)

    val price = priceType match {
      case "open" => recordByCompany(0).open
      case "close" => recordByCompany(0).close
      case "high" => recordByCompany(0).hight
      case "low" => recordByCompany(0).low
    }
  price
  }
  var getPriceForGoog=getPriceWithPlaceHolder("12,06,2020")("GOOG") ("open")
  var getPriceForGoogg =getPriceWithPlaceHolder("12,06,2020")("GOOG") _
  var getPriceForGooggg =getPriceWithPlaceHolder("12,06,2020") _
  println(getPriceForGoog)
  println(getPriceForGoogg("open"))
  println(getPriceForGooggg("DB")("open"))

}
