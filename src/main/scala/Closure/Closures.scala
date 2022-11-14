package Closure

object Closures extends App {
  val readStockRecdValues=()=>{
    val data=io.Source.fromFile("C:\\Users\\HP\\IdeaProjects\\Scala\\src\\main\\scala\\Closure\\stockRecord")
    for{
      line <- data.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)

    }yield {
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

  val getDecisionMakerFunction=(records:Vector[StockRecordd],date:String)=>{
    val currDate=date
    val currRecord=records
    val makeDecision=(percentDelta:Float)=>{
      val filteredRecord=currRecord.filter(_.date==currDate)
      assert(filteredRecord.length==1)
      val record =filteredRecord.head

      val percentAgeMove=((record.close-record.open)/record.open)*100
      if(percentAgeMove>percentDelta){
        println("by based in date"+record.date+"percentage move"+percentAgeMove)
      }else if (percentAgeMove< -percentDelta){
        println("based in date"+record.date+"percentage move"+percentAgeMove)
      }else
        {      println("no call based in date"+record.date+"percentage move"+percentAgeMove)
        }
    }
  }
  val decisionMarker1=getDecisionMakerFunction(readStockRecdValues(),"2020-05-05")
  //decisionMarker1(2)
}
