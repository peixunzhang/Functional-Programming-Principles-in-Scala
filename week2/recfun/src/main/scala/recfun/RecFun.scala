package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /** Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 && r == 0) 1
    else if (c < 0 || r < 0) 0
    else if (c > r) 0
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /** Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def go(chars: List[Char], acc: Int): Boolean = {
      if (chars.isEmpty) acc == 0
      else {
        val ele = chars.head
        if (ele == '(') go(chars.tail, acc + 1)
        else if (ele == ')') {
          if (acc <= 0) false else go(chars.tail, acc - 1)
        } else {
          go(chars.tail, acc)

        }
      }
    }
    // def goo(chars: List[Char], acc: Int): Boolean =
    //   chars match {
    //     case Nil       => acc == 0
    //     case '(' :: xs => go(chars.tail, acc + 1)
    //     case ')' :: xs =>
    //       if (acc < 0) false else go(chars.tail, acc - 1)
    //     case x :: xs => go(chars.tail, acc)

    //   }
    go(chars, 0)
  }

  //chars.count(_ == '(') == chars.count(_ == ')')

  /** Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int =
    if (money == 0) 1
    else if (coins.isEmpty || money < 0) 0
    else
      countChange(money, coins.tail) + countChange(money - coins.head, coins)

}
