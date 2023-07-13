package interviewScala99

import scala.annotation.tailrec
import scala.collection.immutable
import scala.collection.mutable.ListBuffer

object lastElementOfList extends App {

//  val l = List(1,2,3,4,5,6)
//  println(l.last)
//
//  def findLastElement(list1:List[Int]):Int={
//    val lastEle = list1 match {
//      case e :: Nil => e
//      case _ :: tail => findLastElement(tail)
//    }
//    lastEle
//  }
//  print(findLastElement(l))

//  val l = List(1,2,3,4,5,6)
//  def penultimate(l:List[Int]):Int={
//    val op = l match {
//      case h::_::Nil=> h
//      case _::t => penultimate(t)
//    }
//    op
//  }
//  println(penultimate(l))

//  def giveNthElement(n:Int, l:List[Int]):Int={
//    val op = (n,l) match {
//      case (0, h::_)=> h
//      case (n, _::t)=> giveNthElement(n-1, t)
//      case (_, _) => println("n greater than length of list."); throw new NoSuchElementException
//    }
//    op
//  }
//
//  val l = List(1,2,3,4,5,6)
//  println(giveNthElement(40, l))


//  def findLength(n:Int, l:List[Int]):Int={
//    val op = (n,l) match {
//      case (n, _::_::Nil) => n+1
//      case (n, _::t) => findLength(n+1, t)
//    }
//    op
//  }
//    val l = List(1,2,3,4,5,6)
//    println(findLength(1, l))

//  def reverseList(l:List[Int], revList:List[Int]):List[Int]={
//    val op = l match {
//      case Nil => revList
//      case h::tail => reverseList(tail, h::revList)
//    }
//    op
//  }
//
//  val l = List(1,2,3,4,5,6)
//  println(reverseList(l, Nil))

//  val l = List(1,2,3,4,5,6)
//  val op = l.foldLeft(List[Int]()){(acc, e) => e :: acc}
//  println(op)

//  def flattenData(lst: List[Any]): List[Any] = {
//    val op = lst.flatMap(
//        {
//          case e => List(e)
//          case e: List[Any] => flattenData(e)
//        }
//      )
//    op
//  }
//
//  val l = List(List(1, 1), 2, List(3, List(5, 8)))
//  val op = flattenData(l)
//  print(op)

//  def removeConsecutiveDuplicates(lst:List[Char]):List[Char]={
//    val op = lst.foldRight(List[Char]())((e, acc)=>{ // e is right most element
//      if(acc.isEmpty || acc.head != e) e::acc
//      else acc
//    })
//    op
//  }
//
//  val l = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e', 'f', 'f')
//  val op = removeConsecutiveDuplicates(l)
//  println(op)

//  def pack(l:List[Char]):List[List[Char]]={
//    if (l.isEmpty) List[List[Char]]()
//    else{
//      val (packed, rest) = l.span(_==l.head)
//      if (rest == Nil) List(packed)
//      else packed :: pack(rest)
//    }
//  }
//
//  val l = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
//  println(pack(l))

//  def encodeModified(l:List[Char]):List[(Int, Char)]={
//    val op = l.foldRight(List)
//  }
//  val l = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')

//  def decode(l:List[(Int, Char)]):List[Char]={
//    val op = l.flatMap(e => List.fill(e._1)(e._2))
//    op
//  }
//
//  val l = List((4, 'a'), (1, 'b'), (2, 'c'), (2, 'a'), (1, 'd'), (4, 'e'))
//  println(decode(l))

//  def duplicate(l:List[Char]):List[Char]={
//    val op = l.flatMap(e => List.fill(2)(e))
//    op
//  }
//  val l = List('a', 'b', 'c', 'c', 'd')
//  println(duplicate(l))

//  def encodeDirect(l:List[Char]):List[(Int, Char)]={
//    if (l.isEmpty) Nil
//    else {
//      val (packed, rest) = l.span(_ == l.head)
//      (packed.length, packed.head) :: encodeDirect(rest)
//    }
//  }
//
//  val l = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
//  println(encodeDirect(l))

//  def duplicateN(n:Int, l:List[Char]):List[Char]={
//    val op = l.flatMap(e => List.fill(n)(e))
//    op
//  }
//  val l = List('a', 'b', 'c', 'c', 'd')
//  println(duplicateN(3, l))
}