package com.knoldus

sealed trait Tree
case class Node(var left: Tree, var value: String, var right: Tree, var parent: Tree) extends Tree
case object EmptyNode extends Tree