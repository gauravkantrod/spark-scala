package scalaBasics.arrays

import scala.collection.mutable.ArrayBuffer

object ArrayClass extends App {
  val arr1 = new Array(5) // array of nulls
  arr1.foreach(println)
  // arr1(1) = 0 // wont work as arr1 is of null

  val arr2 = Array(1,2,3,4,5,6)
  println(arr2)

  val arr3 = new Array[Int](5)
  arr3(0) = 1
  arr3.foreach(println)

  val arr4 = Array(5)
  arr4.foreach(println)

  val evenNums = for(i<- 1 to 10 if i%2 == 0) yield i
  println(evenNums)

  val arr = Array(1,2,3,4,5,6,7,1,2,3,4)
  val sum1 = arr.reduce((num1, num2) => {
    println(s"$num1, $num2")
    num1+num2
  })
  println(sum1)

  val sum2 = arr.reduceLeft((acc, num2) => {
    println(s"$acc, $num2")
    acc+num2
  })
  println(sum2)

  val sum3 = arr.reduceRight((acc, num2) => {
    println(s"$acc, $num2")
    acc+num2
  })
  println(sum3)

  arr.sorted.foreach(println)
  arr.sortWith(_<_).foreach(println)
  arr.sortWith(_>_).foreach(println)


  val abf = ArrayBuffer[Int]()
  abf += 10
  abf += 20
  abf -= 10
  abf --= List(10,20)
  println(abf)

}