package methods.recursion

/**
  * Author: Tomasz Kawik
  * Date: 14.03.2016
  */


object FlexibleNumeralSystem {

  def main(args: Array[String]): Unit = {
    val c = changeBase(121, 2)
    println(c)
    val d = decode("2x101")
    println(d)
  }

  def changeBase(num: Int, base: Int): String = {

    def findMaxPow(rem: Int): Int = {
      def helper(power: Int): Int = if (rem >= Math.pow(base, power)) helper(power + 1) else power - 1
      helper(0)
    }

    val maximumPowerLowerThanValue = findMaxPow(num)

    def accumulator(remainder: Int, power: Int): String = {
      if (power >= 0) {
        val base2power = Math.pow(base, power).toInt
        val value = remainder / base2power
        value.toString + accumulator(remainder - value * base2power, power - 1).toString
      } else {
        ""
      }
    }
    base.toString + 'x' + accumulator(num, maximumPowerLowerThanValue)
  }

  def decode(str: String): Int = {
    val baseAndNum = "[0-9]+".r.findAllIn(str).toList

    def compute(c: Char, i: Int): Int ={
      c.toString.toInt * Math.pow(baseAndNum.head.toInt, i) toInt
    }

    baseAndNum(1).zipWithIndex.map((element) => compute(element._1, element._2)).sum
  }
}
