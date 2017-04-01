package classes.valueClasses

/**
  * Author: Tomasz Kawik
  * Date: 01.04.2017
  */
class Dollar(val value: Double) extends AnyVal {
  override def toString: String = value + "$"

  def +(that: Dollar) = new Dollar(this.value + that.value)

  def -(that: Dollar) = new Dollar(this.value - that.value)
}

object Dollar {
  def apply(value: Float) = new Dollar(value)
}
