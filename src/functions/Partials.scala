package functions

import scala.collection.mutable

/**
  * Author: Tomasz Kawik
  * Date: 03.03.2016
  */
object Partials {
  def main(args: Array[String]): Unit = {
    println("Matrix of sums 10 x 10\n")
    printer(applicator(10, 10, sum))
    println("\n")
    println("Matrix of multiplications 10 x 10\n")
    printer(applicator(10, 10, multiply))
  }

  def applicator(x: Integer, y: Integer, fun: (Integer, Integer) => Integer): mutable.MutableList[mutable.MutableList[Integer]] = {
    var listOfLists = scala.collection.mutable.MutableList[scala.collection.mutable.MutableList[Integer]]()
    (1 to x).foreach {
      i => {
        var list = scala.collection.mutable.MutableList[Integer]()
        val partFun = fun(i, _: Integer)
        (1 to y).foreach {
          j => list += partFun(j)
        }
        listOfLists += list
      }
    }
    listOfLists
  }

  def printer(listOfLists: Iterable[Iterable[Integer]]): Unit = {
    //Printing
    listOfLists.foreach {
      list => {
        list.foreach(num => print(f"$num%2d "))
        println()
      }
    }
  }

  def sum(x: Integer, y: Integer): Integer = {
    x + y
  }

  def multiply(x: Integer, y: Integer): Integer = {
    x * y
  }
}
