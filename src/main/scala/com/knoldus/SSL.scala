/*
package com.knoldus

import scala.collection.{LinearSeq, mutable}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
/*

class DoubleLinkedList[A](var next: DoubleLinkedList[A], var elem: A, var prev: DoubleLinkedList[A])
  {
  def this(elem: A, next: DoubleLinkedList[A]) {
    this(next, elem, prev)
    if (next != null) {
      this.elem = elem
      this.next = next
      this.next.prev = this
    }
  }
}*/


object AppDriverThread extends App {

  class Count(var counter: Int) {
  def incr() = {
    this.counter = this.counter + 1
  }
}


  val counter = new Count(0)
  for (x <- 0 to 10000) Future {
    synchronized(counter.incr())
}

  Thread.sleep(5000)
  print(counter.counter)

  val a = Option(1)
  val b = Some(1)
  val c = Either[1, ""]
  val d = Some(1)

}

*/
