



abstract class Person {
  def printClass(c: Class[_])
}

object ABC extends Person with App {
  def printClass(c: Class[_]) =  println(c.getSimpleName)
  println(ABC)
}



//printClass(Int)


/*
package com.knoldus

abstract class Node {
  def addNode(x: Int): Node
  def next: Node
  def prev: Node
}




object Empty extends Node {
  override def addNode(x: Int): Node = addNode(x)
  override def next: Node = Empty
  override def prev: Node = Empty
}

class DoublyLinkedList(data: Int, next: Node, prev: Node) extends Node {


  var head = Empty
  override def addNode(x: Int): Node = new DoublyLinkedList(data, Empty, Empty)

  override def next: Node = addNode(data).next

  override def prev: Node = addNode(data).prev

  def push(newData: Int): Unit =  {
    def newNode: Node = new DoublyLinkedList(newData, Empty, Empty)
    newNode.next = head
    newNode.prev = Empty
}



/*
case class Node(data: Int, next: DDL, prev: DDL) extends DDL{
  val head = Empty
  def push(newData: Int): Unit = {
    val newNode = Node(newData, Empty, Empty)
    newNode.next = head
    newNode.prev = Empty
    if (head != null) head.prev = newNode
    head = newNode
  }
*/

}*/
