package methods

/**
  * Author: Tomasz Kawik
  * Date: 03.10.2016
  */
object Test extends App {
  val partiallyApplied1 = sampleFunction(5) _
  val partiallyApplied2 = partiallyApplied1(2)
  val appliedValue = partiallyApplied2(3)

  def sampleFunction(a: Int)(b: Int)(c: Int): Int = a + b + c

  println(partiallyApplied1, partiallyApplied2, appliedValue)
}
