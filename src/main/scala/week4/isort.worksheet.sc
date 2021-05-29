def isort(xs: List[Int]): List[Int] = xs match {
  case List()  => List()
  case y :: ys => insert(y, isort(ys))
}
def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case List()  => List()
  case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
}
val l = isort(List(7, 3, 9, 2))
