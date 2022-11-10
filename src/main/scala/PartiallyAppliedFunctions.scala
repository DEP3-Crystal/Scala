object PartiallyAppliedFunctions extends App {
  val googStockPrices=List(123.1,1241.1,241.1,2212.1,2211.11)

  def checkPricerGreaterThan1400(price: Double):Boolean=price>1400

  val checkPricerGreaterThan1400Function=checkPricerGreaterThan1400 _

//  val googStockPricesGreaterThan1400=
//    googStockPrices.filter(checkPricerGreaterThan1400)

     val google= googStockPrices.filter(checkPricerGreaterThan1400Function)
       println(google)

       def checkPriceInRange(price:Double,lower:Double,upper:Double):Boolean=
         price>=lower && price <=upper

        // val googStockPricesInRangeFunction=checkPriceInRange _

        // val googStockPricesInRange=googStockPrices.filter((price)=>googStockPricesInRangeFunction(price,1390,1410))
         //println(googStockPricesInRange)

}
