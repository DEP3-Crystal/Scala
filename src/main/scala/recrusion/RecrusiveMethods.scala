package recrusion

object RecrusiveMethods extends App {
  def readFinanceData ():Vector[StockRecorddd] = {
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
  def rollingAverage(numDays:Int):Unit={
    var record=readFinanceData()
    while (record.length>=numDays){
      val averageClose=record.map(_.close).take(numDays).sum/numDays
      println(s"Rolling average close for $numDays  days"
              + s"date ${record.head.date}: $averageClose")

      record=record.drop(1)
      rollingAverage(2)

    }
    println("Finished")
  }
  rollingAverage(2)


}
