package classes.valueClasses

/**
  * Author: Tomasz Kawik
  * Date: 01.04.2017
  */
object MultiCurrency {
  implicit def dollarToEuro(dollar: Dollar): Euro = new Euro(dollar.value * 0.9)

  implicit def euroToDollar(euro: Euro): Dollar = new Dollar(euro.value * 1.1)

  implicit def euroToZloty(euro: Euro): Zloty = new Zloty(euro.value * 4.4)

  implicit def zlotyToEuro(zloty: Zloty): Euro = new Euro(zloty.value * 0.22)

  implicit def dollarToZloty(dollar: Dollar): Zloty = new Zloty(dollar.value * 4)

  implicit def zlotyToDollar(zloty: Zloty): Dollar = new Dollar(zloty.value * 0.25)

  def main(args: Array[String]): Unit = {
    val money = Dollar(10) + Zloty(10) + Euro(10)
    println(money)
  }
}