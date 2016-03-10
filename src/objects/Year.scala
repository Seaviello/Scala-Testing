package objects

import scala.collection.immutable.IndexedSeq

/**
  * Author: Tomasz Kawik
  * Date: 21.02.2016
  */
object Year {
  private val monthNames = List("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
  private val abbreviations = List("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
  private val full: IndexedSeq[Month] = (0 to 11).map {
    value => new Month(monthNames(value), abbreviations(value), value)
  }

  def year(): IndexedSeq[Month] = {
    full
  }

  def get(number: Int): Option[Month] = {
    if (number > 11 || number < 0) None
    else Some(full(number))
  }

  def get(name: String): Option[Month] = {
    full.find {
      month => month.fullName == name
    }
  }

  def getSeason(month: Month): Option[String] = {
    month match {
      case Month(_, _, 2) | Month(_, _, 3) | Month(_, _, 4) => Some("Spring")
      case Month(_, _, 5) | Month(_, _, 6) | Month(_, _, 7) => Some("Summer")
      case Month(_, _, 8) | Month(_, _, 9) | Month(_, _, 10) => Some("Fall")
      case Month(_, _, 11) | Month(_, _, 0) | Month(_, _, 1) => Some("Winter")
      case _ => None
    }
  }

  class Month(val fullName: String, val abbreviation: String, val number: Int) {

  }

  class Pop(){
    
  }

  object Month {
    def unapply(month: Month): Option[(String, String, Int)] = Some(month.fullName, month.abbreviation, month.number)
  }

}
