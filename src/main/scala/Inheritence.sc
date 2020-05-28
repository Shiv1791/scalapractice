


trait Element {
  def contents: Array[String]
  val height = contents.length
  val width =
    if (height == 0) 0 else contents(0).length
}

class ArrayElement(conts: Array[String]) extends Element {
  val contents: Array[String] = conts
}

val arrayElement = new ArrayElement(Array("Hello Ayush"))


/*

def max(xs: List[Int]): Option[Int] = xs match {
  case Nil => None
  case List(x: Int) => Some(x)
  case x :: y :: rest => max( (if (x > y) x else y) :: rest )
}
*/

def maxElement(xs: List[Int]) = {
  if (xs.isEmpty) throw new Exception("List is empty")
  xs.reduceLeft((x, y) => if (x > y) x else y)
}

maxElement(List(14,5,8,5,2))

def mapReduce(f:Int=> Int, combine:(Int,Int)=> Int, zero:Int)(a:Int, b:Int): Int = {
  if(a>b) zero
  else
    combine(f(a), mapReduce(f, combine, zero)(a+1, b))
}
def  product(f:Int=> Int)(a:Int, b:Int): Int = {
  mapReduce(f,(x,y) => x * y, 1)(a, b)
}

def sum(f:Int=> Int)(a:Int, b:Int): Int = {
  mapReduce(f, (x, y) => x + y, 0)(a, b)
}




 def productAndSum(a: Int,b: Int): Unit = {
   println(s"The product from ${a} to $b is = ${product(x=>x)(a,b)}")
   println(s"The sum from ${a} to $b is = ${sum(x=>x)(a,b)}")
 }

productAndSum(1,5)



def useStringInterpolation(list: List[Int]): Unit = {
  for(i <-list.indices){
    println(s"$i = ${list(i)}")
  }
}

//def findNthFact(n: Int): Int =


println(useStringInterpolation(List(1,3,4,5,8,6)))
/*
abstract class Element {
  def contents:
  Array[String]
  def width: Int = contents(0).length
  def height: Int = contents.length
  def above(that: Element): Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    elem(this1.contents ++ that1.contents)
  }
  def beside(that: Element): Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(
      for ((line1, line2) <- this1.contents zip that1.contents)
        yield line1 + line2)
  }
  def widen(w: Int): Element =
    if (w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right
    }
  def heighten(h: Int): Element =
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }
  override def toString = contents mkString "\n"
}
object Element {
  private class ArrayElement(
                              val contents: Array[String]
                            ) extends Element
  private class LineElement(s: String) extends Element {
    val contents = Array(s)
    override def width = s.length
    override def height = 1
  }
  private class UniformElement(
                                ch: Char,
                                override val width: Int,
                                override val height: Int
                              ) extends Element {
    private val line = ch.toString * width
    def contents = Array.fill(height)(line)
  }
  def elem(contents:
           Array[String]): Element =
    new ArrayElement(contents)
  def elem(chr: Char, width: Int, height: Int): Element =
    new UniformElement(chr, width, height)
  def elem(line: String): Element =
    new LineElement(line)
}

object Spiral {
  val space = elem(" ")
  val corner = elem("+")
  def spiral(nEdges: Int, direction: Int): Element = {
    if (nEdges == 1)
      elem("+")
    else {
      val sp = spiral(nEdges - 1, (direction + 3) % 4)
      def verticalBar = elem('|', 1, sp.height)
      def horizontalBar = elem('-', sp.width, 1)
      if (direction == 0)
        (corner beside horizontalBar) above (sp beside space)
      else if (direction == 1)
        (sp above space) beside (corner above verticalBar)
      else if (direction == 2)
        (space beside sp) above (horizontalBar beside corner)
      else
        (verticalBar above corner) beside (space above sp)
    }
  }
  def main(args: Array[String]) = {
    val nSides = args(0).toInt
    println(spiral(nSides, 0))
  }
}*/

/*

trait Human{
  def hello = println("the human")
}


trait Mother{
  def hello = println("the Mother")
}
trait Father{
  def hello = println("the Father")
}


class Child extends Human with Mother with Father {
  override def hello: Unit = println(super.hello)

  hello
}

*/
