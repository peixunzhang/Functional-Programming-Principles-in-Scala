abstract class BBList[A] {
  def sum(zero: A, combine: (A, A) => A): A
  def sumAcc(combine: (A, A) => A, acc: A): A
  def map[B](f: A => B): BBList[B]
  def reduce[B](zero: B, combine: (B, A) => B): B
  def filter(f: A => Boolean): BBList[A]
  def prepend(bb: A): BBList[A]
}

class ManyBBs[A](head: A, tail: BBList[A]) extends BBList[A] {
  def sum(zero: A, combine: (A, A) => A): A = {
    // head, tail, combine, zero
    combine(head, tail.sum(zero, combine))
  }
  def sumAcc(combine: (A, A) => A, acc: A): A = {
    //head, tail, combine, acc
    combine(head, tail.sumAcc(combine, acc))
  }
  def map[B](f: A => B): BBList[B] = {
    // head, tail, f
    new ManyBBs[B](f(head), tail.map(f))
  }
  def reduce[B](zero: B, combine: (B, A) => B): B = {
    //head, tail, zero, combine
    combine(tail.reduce(zero, combine), head)
  }
  def filter(f: A => Boolean): BBList[A] = {
    //head, tail, f
    if (f(head))
      //keep head
      new ManyBBs(head, tail.filter(f))
    else
      tail.filter(f)
  }
  def prepend(bb: A): BBList[A] =
    new ManyBBs(bb, this)
}

class NoBB[A] extends BBList[A] {
  def sum(zero: A, combine: (A, A) => A): A = zero
  def sumAcc(combine: (A, A) => A, acc: A): A = {
    //combine, acc
    acc
  }
  def map[B](f: A => B): BBList[B] = {
    //f
    new NoBB[B]
  }
  def reduce[B](zero: B, combine: (B, A) => B): B = {
    //zero, combine
    zero
  }
  def filter(f: A => Boolean): BBList[A] = {
    //f
    new NoBB[A]
  }
  def prepend(bb: A): BBList[A] =
    new ManyBBs(bb, new NoBB())
}

val bbs = new ManyBBs(1, new ManyBBs(2, new NoBB))
bbs.sum(0, _ + _)
assert(bbs.reduce[String]("[]", (s, i) => s"$i:$s") == "1:2:[]")
bbs.prepend(0)
// () => BBList[A]
// (A, BBList[A]) => BBList[A]
