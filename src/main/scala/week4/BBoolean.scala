package week4
abstract class BBoolean {
  def ifThenElse[T](t: => T, e: => T): T
  def &&(x: => BBoolean): BBoolean = ifThenElse(x, False)
  def ||(x: => BBoolean): BBoolean = ifThenElse(True, x)
  def unary_! : BBoolean = ifThenElse(False, True)
  def ==(x: BBoolean): BBoolean = ifThenElse(x, !x)
  def !=(x: BBoolean): BBoolean = !(this == x)
  def <(x: BBoolean): BBoolean = ifThenElse(False, x)
}

object True extends BBoolean {
  def ifThenElse[T](t: => T, e: => T): T = t
}

object False extends BBoolean {
  def ifThenElse[T](t: => T, e: => T): T = e
}
