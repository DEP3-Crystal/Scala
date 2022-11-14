package expressionBlock

object FunctionInvocationWithExpressionBlock extends App {

  val readFinanceData=()=>{
    val data=io.Source.fromFile("C:\\Users\\HP\\IdeaProjects\\Scala\\src\\main\\scala\\ComplexOperator\\stockRecord")
    for{
       lines<-data.getLines().drop(1).toVector
       cols = lines.split(",").map(_.trim)
    }yield StockRecorddd(
      cols(0),
      cols(1).toFloat,
      cols(2).toFloat,
      cols(3).toFloat,
      cols(4).toFloat,
      cols(5)
    )
  }
  val records=readFinanceData()
  val getStockDetais=(company:String)=>records.filter(_.company==company)
  val ttmStockDetais=getStockDetais("TTM")
  println(ttmStockDetais)

  val randomStockDetais=getStockDetais{
    val list=List("MSFT","GOOG","TM","TTM","DB","BNS")
    val randomNumber=util.Random.nextInt(list.length)
    list(randomNumber)

  }
  println(randomStockDetais)

}
