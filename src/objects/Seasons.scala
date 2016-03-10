package objects

import objects.Year.Month

/**
  * Author: Tomasz Kawik
  * Date: 21.02.2016
  */
object Main {
  def main(args: Array[String]): Unit = {
    val april: Month = Year.get(3).get
    println(april.fullName + " is in " + Year.getSeason(april).get)
  }
  def fun(): Unit ={

  }

}