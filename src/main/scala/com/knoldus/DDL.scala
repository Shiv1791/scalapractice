package com.knoldus

sealed trait DLL[+A] extends (Int => A)
case class LeftNil[+A]()(n: => DLL[A]) extends DLL[A] {
  def next = n
  def apply(i: Int) = next(i)
}
case class RightNil[+A]()(p: => DLL[A]) extends DLL[A] {
  def prev = p
  def apply(i: Int) =
    throw new IndexOutOfBoundsException("DLL accessed at " + i)
}
case class Cons[+A](value: A)(p: => DLL[A], n: => DLL[A]) extends DLL[A] {
  def next = n
  def prev = p
  def apply(i: Int) = if (i == 0) value else next(i - 1)
}

object DLL extends App {
  def apply[A](sll: List[A]): DLL[A] = {
    def build(rest: List[A]): (=> DLL[A]) => DLL[A] = rest match {
      case Nil => RightNil[A]() _
      case h :: t => {
        l => {
          lazy val r: DLL[A] = build(t){c}
          lazy val c: DLL[A] = Cons(h)(l, r)
          c
        }
      }
    }
    lazy val r: DLL[A] = build(sll){l}
    lazy val l: DLL[A] = LeftNil(){r}
    l
  }

  val dll = DLL((42 to 100).toList)

  println((1 to 20).map(dll))
}

