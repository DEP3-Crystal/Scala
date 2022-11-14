package DealingWithExceptionAndMissingValue

object VariableArguments extends App {
  val readFinanceData = () => {
    val data = io.Source.fromFile("C:\\Users\\HP\\IdeaProjects\\Scala\\src\\main\\scala\\DealingWithExceptionAndMissingValue\\stockRecord")
    for {
      lines <- data.getLines().drop(1).toVector
      cols = lines.split(",").map(_.trim)
    } yield StockRecorddd(
      cols(0),
      cols(1).toFloat,
      cols(2).toFloat,
      cols(3).toFloat,
      cols(4).toFloat,
      cols(5)
    )
  }
  private val data=readFinanceData()

  def getRecords(comp:String*):Vector[(String,String,Float)]={
    //println(comp.getClass)
    for(c<-comp) println(c)

    val filteredRecord=data.filter(rec=>comp.contains(rec.company))

    filteredRecord.map(rec=>(rec.date,rec.company,rec.close))
  }
    val records=getRecords("MSFT")
    val recordss=getRecords("MSFT","TM")
    val tickers=List("MSFT","TM")

    val recordsss=getRecords(tickers: _*)


     //records.foreach(i=>println(i))
    //recordss.foreach(i=>println(i))
   // recordsss.foreach(i=>println(i))

  def getRecordss(date:String,comp: String*): Vector[(String, String, Float)] = {
    val dateFilterRecord=data.filter(i=>i.date==date)

    val filteredRecords = dateFilterRecord.filter(rec => comp.contains(rec.company))

    filteredRecords.map(rec => (rec.date, rec.company, rec.close))
  }
  val recordssss=getRecordss(date="12-06-2020","MSFT","TM")
  recordssss.foreach(i=>println(i))

}
