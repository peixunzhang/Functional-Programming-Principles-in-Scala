import week4._

def id[A](a: A): A = a

id[Int](3) + 3
id[BBoolean](True) && True

val zero = Zero
val one = zero.successor
val two = one.successor
val three = two.successor
val four = three.successor

four - two + four
