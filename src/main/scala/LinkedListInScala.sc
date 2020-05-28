
sealed trait ConsInterface[+A] {
  def value: A
  def next: ConsInterface[A]
}

case class LinkedListInScala[+A] (val value: A, val next: ConsInterface[A]) extends ConsInterface[A]{
  override def toString = s"head: $value, next: $next"
}

object NilCons extends ConsInterface[Nothing] {
  def value = throw new NoSuchElementException("head of empty list")
  def next = throw new UnsupportedOperationException("tail of empty list")
}


object ConsTutorialDriver {
  def main(args: Array[String]): Unit = {
    val c1 = LinkedListInScala(1, NilCons)
    val c2 = LinkedListInScala(2, c1)
    val c3 = LinkedListInScala(3, c2)
    val c4 = LinkedListInScala(4, c3)
    println(c1)
    println(c2)
    println(c3)
    println(c4)
  }

}

