import scala.collection.mutable.ListBuffer
1 + 2
def abs(x: Double) = if (x < 0) -x else x
abs(3)
abs(-3)
abs(3) == abs(-3)

def sqrt(x: Double) = {
  def sqrtIter(guess: Double): Double =
    if (isGoodEnough(guess)) guess
    else sqrtIter(improve(guess))

  def isGoodEnough(guess: Double): Boolean =
    abs(guess * guess - x) < 0.001 * x

  def improve(guess: Double): Double =
    (guess + x / guess) / 2

  sqrtIter(1.0)
}
sqrt(2)
sqrt(4)
sqrt(0.000001)
