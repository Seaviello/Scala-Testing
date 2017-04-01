package classes.valueClasses

/**
  * Author: Tomasz Kawik
  * Date: 01.04.2017
  */
trait Currency[T] {
  val value: Double

  def +(that: T): T

  def -(that: T): T
}
