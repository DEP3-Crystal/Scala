package nestedMethod

object NestedMethods extends App {
  val readFinanceData = () => {
    val data = io.Source.fromFile("C:\\Users\\HP\\IdeaProjects\\Scala\\src\\main\\scala\\nestedMethod\\stockRecord")
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


  def printRecords(comp:String):Unit={
    println ("Date      |Ticker   |Close")
     def printRecords():Unit={
      for (row<-data.filter(i=>i.company==comp)){
        println(row.date+row.company+row.close)
      }
     }
    printRecords()

  }
  //printRecords("MSFT")



  def printStockData(comp:String):Unit={
    println ("Date      |Ticker   |Close")

    printRecord()
  def printRecord():Unit={
    def filteredRecord=data.filter(_.company==comp)
    for(row<-filteredRecord){
      println(row.date+row.company+"   "+row.close)
    }

    printSummary()

    def printSummary():Unit={
      printAvarage()

      def printAvarage():Unit={
        val averageClose=filteredRecord.filter(_.company==comp)
          .map(_.close).sum/filteredRecord.size
        println(s"Average close ${averageClose}")

        printStandartDeviation()

       def printStandartDeviation():Unit={
        var x=0.0

         for(record<-filteredRecord){
           x=x+Math.pow(record.close-averageClose,2)
         }

         val variance=x/filteredRecord.size

         println("Standart deviation close: "+Math.sqrt(variance))
        }

      }

    }

  }

  }
  println(printStockData("BNS"))


}
