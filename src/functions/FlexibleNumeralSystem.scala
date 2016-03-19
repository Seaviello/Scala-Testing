package functions

/**
  * Author: Tomasz Kawik
  * Date: 14.03.2016
  */


object FlexibleNumeralSystem {

  def main(args: Array[String]): Unit = {
    val c: String = changeBase(9, 2)
    println(c)
    println(decode("2x101"))
  }

  def concatArray[A](num: Array[A], prefix: String): String = {
    num.foldLeft(prefix)((previous, next) => previous.toString + next.toString)
  }

  def changeBase(num: Int, base: Int): String = {


    def findMaxPow(rem: Int): Int = {
      var i = 0
      while (rem >= Math.pow(base, i)) {
        i += 1
      }
      i
    }

    val result = Array.fill(findMaxPow(num)) {
      0
    }

    var x = num
    while (x > 0) {
      val i = findMaxPow(x)
      result(result.length - i) = (x / Math.pow(base, i - 1)).toInt
      x = x - (result(result.length - i) * Math.pow(base, i - 1)).toInt
    }
    concatArray(result, base.toString + 'x')
  }

  def decode(str: String) = {
    val baseAndNum = "[0-9]+".r.findAllIn(str).toList
    var result = 0
    for ( i <- 0 until baseAndNum(1).length){
      result += compute(baseAndNum(1).charAt(i), baseAndNum(1).length - i -1 )
    }
    def compute(c: Char, i: Int): Int ={
      c.toString.toInt * Math.pow(baseAndNum.head.toInt, i) toInt
    }
    result
  }
}
