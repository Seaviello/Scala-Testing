package classes.valueClasses

/**
  * Author: Tomasz Kawik
  * Date: 01.04.2017
  */
class Zloty(val value: Double) extends AnyVal {
  override def toString: String = value + "zł"

  def +(that: Zloty) = new Zloty(this.value + that.value)

  def -(that: Zloty) = new Zloty(this.value - that.value)
}

object Zloty {
  def apply(value: Float) = new Zloty(value)
}
