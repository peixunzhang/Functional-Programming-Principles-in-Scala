trait Expr {
  override def toString(): String =
    show(this)
}
case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(a: Expr, b: Expr) extends Expr
case class Var(c: String) extends Expr
def show(e: Expr): String = e match {
  case Number(a)                  => a.toString()
  case Sum(a, b)                  => s"$a + $b"
  case Prod(Sum(a, b), Sum(c, d)) => s"($a + $b) * ($c + $d)"
  case Prod(Sum(a, b), c)         => s"($a + $b) * $c"
  case Prod(a, Sum(b, c))         => s"$a * ($b + $c)"
  case Prod(a, b)                 => s"$a * $b"
  case Var(a)                     => a

}

show(Sum(Number(22), Number(1)))
show(Sum(Prod(Number(2), Var("x")), Var("y")))
show(Prod(Sum(Number(2), Var("x")), Var("y")))
show(Prod(Var("x"), Sum(Number(2), Number(1))))
