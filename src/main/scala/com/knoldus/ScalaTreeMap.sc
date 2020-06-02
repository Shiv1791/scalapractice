import scala.concurrent.{Await, Future}

import scala.concurrent.duration._
import scala.language.postfixOps
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
sealed trait Tree[+T]

case class Node[A](v: A, l: Tree[A], r: Tree[A]) extends Tree[A]
case class Leaf[A](v: A) extends Tree[A]
case object Empty extends Tree[Nothing]


//it returns the height of the tree if it is balanced, -1 otherwise
def balanced(root: Tree[_]): Int = root match {
  case Empty => 0
  case Leaf(_) => 1
  case Node(_, left, right) =>
    val l = balanced(left)
    val r = balanced(right)
    if (l < 0 || r < 0 || (l - r).abs > 1) -1 else (l max r) + 1
}



/*

//find the last element in the list
  def lastElement[A](list: List[A]):A = {
    list match {
      case x:: Nil => x
      case _ :: xs => lastElement(xs)
      case  _=> throw new NoSuchElementException
    }
  }

//Find the last but one element of a list

def secondLastElement[A](list: List[A]): A = {
  list match {
    case x :: _ :: Nil => x
    case _ :: xs => secondLastElement(xs)
    case _ => throw new NoSuchElementException
  }
}

//Find the kth last  element of a list

def kthLastElement[A](k: Int, list: List[A]): A = {
  list match {
    case _::tail if tail.length == k => tail.head
    case _ :: xs => kthLastElement(k, xs)
    case _ => throw new NoSuchElementException
  }
}


val list =  List(1,2,3,4,5,6,9,1,10,97,45)


println(kthLastElement(5,list))

*/

/*

def sum(a:String, b:String): Int = a.toInt+b.toInt


def b: Future[Int] = {

  Future {
    sum("1","2")}
}

def c = {
  Future{
    b.map(println)}
}

Thread.sleep(10000)
println(c)
*/
