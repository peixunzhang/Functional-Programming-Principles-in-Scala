package week4
abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat = new Succ(this)

  def +(that: Nat): Nat
  def -(that: Nat): Nat =
    if (that.isZero) this else this.predecessor - that.predecessor
}
object Zero extends Nat {
  def isZero: Boolean = true
  def predecessor: Nat = throw new IllegalStateException
  def +(that: Nat): Nat = that

  override def toString(): String = "Zero"
}

class Succ(n: Nat) extends Nat {
  def isZero: Boolean = false
  def predecessor: Nat = n
  def +(that: Nat): Nat =
    this.predecessor + that.successor

  override def toString(): String = s"Succ($n)"
}
