abstract class List[+A]

class Cons[A](head: A, tail: List[A]) extends List[A]
object Nil extends List[Nothing]

val a: List[Int] = Nil
val b: List[String] = Nil

// const :: a -> b -> a

def const[A](a: A): Any => A = _ => a

val intConst = const(1)

val s: String => Int = intConst
val b1: Boolean => Int = intConst

trait Option[+A]
class Some[A](value: A) extends Option[A]
object None extends Option[Nothing]
