package invokingMethodWithNamedArguments


object NamedAndDefaultArgument extends App {
  val readStockRecdValues = () => {
    val data = io.Source.fromFile("C:\\Users\\HP\\IdeaProjects\\Scala\\src\\main\\scala\\invokingMethodWithNamedArguments\\stockRecord")
    for {
      line <- data.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)

    } yield {
      StockRecordd(
        cols(0),
        cols(1).toFloat,
        cols(2).toFloat,
        cols(3).toFloat,
        cols(4).toFloat,
        cols(5)
      )
    }

  }
  val records=readStockRecdValues()
  //records.foreach(i=>println(i))

  def getStockPriceDetails(date:String,company:String,priceType:String):(String,String,Float)={
    println(s"Acessing records for ${date}")
  var filteredRecord=records.filter(i=>i.date==date)

    filteredRecord=filteredRecord.filter(_.company==company)

    val record=filteredRecord(0)

    println(s"Accesing price type ${priceType}")

    val price=priceType match{
      case "open" => record.open
      case "close" => record.close
      case "high" => record.hight
      case "low" => record.low
    }
    (record.date,record.company,price)
  }

  def getStockPriceDetailss(date: String)( company: String="BNS")( priceType: String): (String, String, Float) = {
    println(s"Acessing records for ${date}")
    var filteredRecord = records.filter(i => i.date == date)

    filteredRecord = filteredRecord.filter(_.company == company)

    val record = filteredRecord(0)

    println(s"Accesing price type ${priceType}")

    val price = priceType match {
      case "open" => record.open
      case "close" => record.close
      case "high" => record.hight
      case "low" => record.low
    }
    (record.date, record.company, price)
  }

  //println(getStockPriceDetails("12-06-2020","BNS","open"))
  println(getStockPriceDetailss(date="12-06-2020")()(priceType="open"))
}
