import scala.collection.mutable.ListBuffer


/*
    Applications of tree
    Heap is a kind of tree that is used for heap sort.
    A modified version of a tree called Tries is used in modern routers to store routing information.
    Most popular databases use B-Trees and T-Trees, which are variants of the tree structure we learned above to store their data
    Compilers use a syntax tree to validate the syntax of every program you write.
    Store hierarchical data, like folder structure, organization structure, XML/HTML data.
    Binary Search Tree is a tree that allows fast search, insert, delete on a sorted data. It also allows finding closest item
    Heap is a tree data structure which is implemented using arrays and used to implement priority queues.
    B-Tree and B+ Tree : They are used to implement indexing in databases.
    Syntax Tree: Used in Compilers.
    K-D Tree: A space partitioning tree used to organize points in K dimensional space.
    Trie : Used to implement dictionaries with prefix lookup.
    Suffix Tree : For quick pattern searching in a fixed text.
    Spanning Trees and shortest path trees are used in routers and bridges respectively in computer networks
    As a workflow for compositing digital images for visual effects.

*
*/

case class Tree(data: Int, left: Option[Tree] = None, right: Option[Tree] = None)

  val branch = Tree(1, Some(Tree(2, Some(Tree(4)), Some(Tree(5)))), Some(Tree(3, Some(Tree(6)), Some(Tree(7)))))
  var inorderNodeData = new ListBuffer[Int]()



/*
  def addElementInList[A](value: A ,list: List[A]) = {
    value match {
      case Nil => List(value)
      case _=> list:::List(value)
    }
}
*/


  def preOrder(node: Tree): Unit = {
    print(node.data)
    if (node.left.isDefined) preOrder(node.left.get)
    if (node.right.isDefined) preOrder(node.right.get)
  }

  def inOrder(node: Tree): Unit = {
    if (node.left.isDefined) inOrder(node.left.get)
    //val list = addElementInList(node.data, List())
    inorderNodeData += node.data
    //println("==============   "+list)
    if (node.right.isDefined) inOrder(node.right.get)
  }

  def postOrder(node: Tree): Unit = {
    if (node.left.isDefined) postOrder(node.left.get)
    if (node.right.isDefined) postOrder(node.right.get)
    print(node.data)
  }


def maxDepth(root: Tree): Int = {
  if (root == null) {
    0
  } else {
    Math.max(maxDepth(root.left.get), maxDepth(root.right.get)) + 1
  }
}


  println("  -> PreOrder" + preOrder(branch))
  println("  -> InOrder " + inOrder(branch))
  println("  -> PostOrder " + postOrder(branch))

  println("\n\n\n"+inorderNodeData.toList)