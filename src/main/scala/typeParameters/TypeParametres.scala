package typeParameters

object TypeParametres  {
  def pickRandomStock (ticker:Seq[String]):String={
    val randomNumber=util.Random.nextInt(ticker.length)
    ticker(randomNumber)
  }

  def pickRandomQuantity(ticker: Seq[Int]): Int = {
    val randomQunatity = util.Random.nextInt(ticker.length)
    ticker(randomQunatity)
  }
  def pickRandomValue(ticker:Seq[Double]):Double={
    val randomQunatity=util.Random.nextInt(ticker.length)
    ticker(randomQunatity)
  }
  val stock=pickRandomStock(List("awd","Awd","Adw","AWD"))
  val quantity=pickRandomQuantity(List(1,2,3,4,5))
  val value=pickRandomValue(List(1.1,2.4,3.4,4.44,5.22))

  def main(args: Array[String]): Unit =
  println(s"stock: ${stock} quantity: ${quantity} value: ${value}")
}
