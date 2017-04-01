package classes.valueClasses

/**
  * Author: Tomasz Kawik
  * Date: 01.04.2017
  */

class Euro(val value: Double) extends AnyVal {
  override def toString: String = value + "€"

  def +(that: Euro) = new Euro(this.value + that.value)

  def -(that: Euro) = new Euro(this.value - that.value)
}

object Euro {
  def apply(value: Float) = new Euro(value)
}
