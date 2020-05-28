/*
def sum(a: Int, b: Int) = a+b

val abc =  sum _

val ab = sum(1, _)

def  sumCurried(a: Int)(b: Int) = a+ b

val c = sumCurried _

val d = sumCurried(2) _

*/


sealed trait ConsInterface[+A] {
  def value: A
  def next: ConsInterface[A]
  def prev: ConsInterface[A]
}

case class Cons[+A] (val value: A, val next: ConsInterface[A], val prev: ConsInterface[A]) extends ConsInterface[A] {
  override def toString = s"head: $value, next: $next , prev: $prev"
}

object NilCons extends ConsInterface[Nothing] {
  def value = throw new NoSuchElementException("head of empty list")
  def next = throw new UnsupportedOperationException("tail of empty list")
  def prev = throw new UnsupportedOperationException("No previous list")
}

object ConsTutorialDriver {
  val c1 = Cons(1, c2, NilCons)
  val c2 = Cons(2, c3, c1)
  val c3 = Cons(3, NilCons, c2)
  println(c1)
  println(c2)
  println(c3)
}

ConsTutorialDriver.c3