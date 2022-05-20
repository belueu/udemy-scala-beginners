package lectures.part3fp

import scala.util.Random

object Sequences extends App {

  // Seq
  val aSequence = Seq(1, 3, 2, 4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(7, 5, 6))
  println(aSequence.sorted)

  // Range
  val aRange: Seq[Int] = 1 until 10 // (1 until 10) - numbers from 1 to 9 and (1 to 10) - numbers from 1 to 10
  aRange.foreach(println)

  (1 to 10).foreach(print)
  println()
  (1 to 10).map(print)
  (1 to 10).foreach(_ => println("Hello"))

  // List
  val aList = List(1, 2, 3, 4)
  val prepended = 42 +: aList
  val appending = aList :+ 55
  println(prepended)
  println(appending)

  val apples5 = List.fill(5)("apple")
  println(apples5)

  println(aList.mkString("-|-"))

  // Array
  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[String](3)

  println(threeElements)

  threeElements.foreach(println)

  // mutation
  numbers(2) = 0 // syntax sugar for numbers.update(2, 0)
  numbers.update(3, 42) // "updates"/mutates the value found at index 3 (the fourth element in the Array)
  println(numbers.mkString(" "))

  // Arrays and Sequences
  val numbersSeq: Seq[Int] = numbers
  println(numbersSeq) // implicit conversion

  // Vectors
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  // performance test: vectors vs lists
  val maxRuns = 1000
  val maxCapacity = 1_000_000
  def getWriteTime(collection: Seq[Int]): Double = {

    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      // operation
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    (times.sum * 1.0 / maxRuns) / 1_000_000 // get the number of seconds
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // keeps reference to tail
  // updating an element in the middle is slow
  println(getWriteTime(numbersList))
  // depth of the tree is small
  // needs to replace an entire 32-element chunk
  println(getWriteTime(numbersVector))

}
