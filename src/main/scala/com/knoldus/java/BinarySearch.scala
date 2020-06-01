package com.knoldus.java



/*
* Time complexity of linear search -O(n) , Binary search has time complexity O(log n).
* */
class BinarySearch {

  def binarySearch(arr: Array[Int], l: Int, r: Int, x: Int): Int = {
    if (r >= l) {
      val mid = l + (r - l) / 2
      // If the element is present at the
      // middle itself
      if (arr(mid) == x) return mid
      // If element is smaller than mid, then
      // it can only be present in left subarray
      if (arr(mid) > x)
        binarySearch(arr, l, mid - 1, x)
      else
        binarySearch(arr, mid + 1, r, x)
    }
    else
    -1
  }
}


class LinearSearch {


  def linearSearch(list: List[Int], x: Int): Unit = {
    list match {
      case List() => println("In Linear search Not present")
      case y::ys => if(y == x) println("In Linear search Present") else linearSearch(ys,x)
    }
  }
}

object MainMethod{

  def main(args: Array[String]): Unit = {

    val obj = new BinarySearch
    val arr = Array(2, 3, 4, 10, 40 )

    val result = obj.binarySearch(arr, 0, arr.length-1, 10)

    val linearSearchObj = new LinearSearch
    linearSearchObj.linearSearch(arr.toList, 101)

    if(result == -1)
      println("In Binary search not Present")
    else
      println("In Binary search Present")
  }
}
