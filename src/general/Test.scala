package general

/**
  * Author: Tomasz Kawik
  * Date: 03.10.2016
  */
object Test {

  def main(args: Array[String]): Unit = {
    def x(a:Int)(b: Int)(c: Int) = a + b + c
    val y = x(5)_
    println(y)
    val z = y(2)
    println(z)
    println(z(3))
  }

}
