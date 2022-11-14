package higherOrderFunction
object blabla extends App {
  val readFinanceData = () => {
    val data = io.Source.fromFile("C:\\Users\\HP\\IdeaProjects\\Scala\\src\\main\\scala\\higherOrderFunction\\stockRecord")
    for {
      lines <- data.getLines().drop(1).toVector
      cols = lines.split(",").map(_.trim)
    } yield Records(
      cols(0),
      cols(1).toFloat,
      cols(2).toFloat,
      cols(3).toFloat,
      cols(4).toFloat,
      cols(5)
    )
  }
  val records=readFinanceData()

  val getStockDetails=(company:String,
                       extractFunction:(Records)=>Float)=>{
    val filteredRecords=records.filter(_.company==company)
    assert(filteredRecords.length==2)
    //println(filteredRecords)
    extractFunction(filteredRecords(1))
    extractFunction(filteredRecords(0))
  }
  val ttmStockRecord=getStockDetails("TTM",(record:Records)=>record.hight)
  println(ttmStockRecord)

//  val ttmStockRecordd = getStockDetails("TTM", (record: Records) => record.low)
//  println(ttmStockRecordd)
}
