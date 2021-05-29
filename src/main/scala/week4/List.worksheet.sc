trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}
class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty: Boolean = false
}
class Nil[T] extends List[T] {
  def isEmpty: Boolean = true

  def head: T = throw new NoSuchElementException

  def tail: List[T] = throw new NoSuchElementException

}
object List {
  def apply[T]() = new Nil[T]
  def apply[T](t: T): List[T] = new Cons(t, new Nil)
  def apply[T](t: T, t2: T): List[T] = new Cons(t, (new Cons(t2, new Nil)))
}

List()
List(1)
List(1, 2)
