package ComplexOperator;

object FunctionLiteralsAndPlaceHolders extends App {
  val readFromFileCar = () =>  {
    val source = io.Source.fromFile("C:\\Users\\HP\\IdeaProjects\\Scala\\src\\main\\scala\\car..txt")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)

    }
    yield {
      if (cols.length == 10) {
        //        println(cols.toVector)
        StockRecord(
          cols(0),
          cols(1).toFloat,
          cols(2),
          cols(3).toInt,
          cols(4),
          cols(5),
          cols(6),
          cols(7),
          cols(8),
          cols(9)
        )
      } else {
        StockRecord(
          cols(0),
          cols(1).toFloat,
          cols(2),
          cols(3).toInt,
          cols(4),
          cols(5),
          cols(6),
          cols(7),
          cols(8),
          "null"
        )
      }

    }
  }

  var data = readFromFileCar()

  val getTotalNumberOfRows = () => data.size

  data.foreach(data => println(data))


    var getAvgPriceValue = () => data.map(i => i.price).sum / data.size

    val getMinPriceValue = () => data.map(_.price).min

    val getMaxPriceValue = () => data.map(_.price).max

    val getValueOnDate = (givenDate: String) => {
      val filteredClose = data.filter(_.registration == givenDate)

      filteredClose.map(_.price).head
    }

    val date = "2020";
    println(s"number of rows: ${getTotalNumberOfRows()}")
    println("average price: " + getTotalNumberOfRows())
    println("min price: " + getTotalNumberOfRows())
    println("max price: " + getTotalNumberOfRows())
 //   var priceDelta=(_:Double)-(_:Double)
//
//    val getDailyDelta=(openPrice:Double,closePrice:Double,
//                      delta:(Double,Double)=>Double)=>delta(openPrice,closePrice)
//    //val price=StockRecord(data.filter(._pri==))
//    print(getDailyDelta(1.1,3.2,priceDelta))




}