import scala.collection.mutable.ListBuffer
//def factorial(n: Int): Int =
//  if (n == 0) 1 else n * factorial(n - 1)
factorial(0)

def factorial(n: Int): Int = {
  def loop(acc: Int, n: Int): Int =
    if (n == 0) acc
    else loop(acc * n, n - 1)
  loop(1, n)
}
