package OrderFunction

object HigherOrderFunctions extends App {
  val readFromStockRecord=()=>{
    val source = io.Source.fromFile("C:\\Users\\HP\\IdeaProjects\\Scala\\src\\main\\scala\\OrderFunction\\stockRecord")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)

    }
    yield {


        StockRecord(
          cols(0),
          cols(1).toFloat,
          cols(2).toFloat,
          cols(3).toFloat,
          cols(4).toFloat,
          cols(5)
        )
      }

    }



  val AllRecords=readFromStockRecord()

  //AllRecords.foreach(k=>println(k))

  val extractHighPrice=(records:Vector[StockRecord])=>{
    for(rec<-records)
      yield (rec.company,rec.close)
  }

  val extractCloseLowCompany=(reco:Vector[StockRecord])=>{
    for(rec<-reco)
      yield (rec.close,rec.low,rec.company)
  }

  val extractPriceDelta=(records:Vector[StockRecord])=>{
    for(rec<-records)
      yield (rec.company,rec.close-rec.open)
  }

  val extractInfo=(records:Vector[StockRecord],
                   extractFunction:Vector[StockRecord]=>Vector[(String,Float)])=>{
    extractFunction(records)
  }

 // println(extractHighPrice(AllRecords))
  //println(extractPriceDelta(AllRecords))
  println(extractInfo(AllRecords,extractPriceDelta))

}
