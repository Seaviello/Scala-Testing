package functions

import scala.collection.immutable

/**
  * Author: Tomasz Kawik
  * Date: 03.03.2016
  */
object Mapping {
  def main(args: Array[String]): Unit = {
    println("Matrix of sums 10 x 10\n")
    printer(applicator(10, 10, (x, y) => x + y))
    println("\n")
    println("Matrix of multiplications 10 x 10\n")
    printer(applicator(10, 10, (x, y) => x * y))
  }

  def applicator(x: Integer, y: Integer, fun: (Integer, Integer) => Integer): immutable.IndexedSeq[immutable.IndexedSeq[Integer]] = {
    (1 to x).map {
      i => (1 to y).map {
        j => fun(i, j)
      }
    }
  }

  def printer(listOfLists: Iterable[Iterable[Integer]]): Unit = {
    //Printing
    listOfLists.foreach {
      list => {
        list.foreach(num => print(f"$num%3d "))
        println()
      }
    }
  }
}
