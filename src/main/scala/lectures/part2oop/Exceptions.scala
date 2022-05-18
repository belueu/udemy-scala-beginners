package lectures.part2oop

import java.nio.BufferUnderflowException
import scala.annotation.tailrec

object Exceptions extends App {

  val x: String = null
  //  println(x.length)
  // this ^^ will crash with NPE

  // throwing and catching exceptions
  //  val aWierdValue = throw new NullPointerException()

  // Throwable classes extend the Throwable class
  // Exception and Error are the major Throwable subtypes

  // 2. How to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you")
    else 42

  val potentialFail = try {
    // code that might fail
    getInt(false)
  } catch {
    case e: RuntimeException => 43 // println("Caught a runtime exception")
  } finally {
    // code that will get executed NO MATTER WHAT
    // the finally block is optional
    // does not influence the return type of this exceptions
    // use finally only for side effects
    println("finally")
  }

  println(potentialFail)

  // 3. How to define your own exceptions
  class MyException extends Exception

  val exception = new MyException

  //  throw exception

  /*
    1. Crash program with an OutOfMemoryError
    2. Crash with StackOverflowError
    3. PocketCalculator
      - add(x, y)
      - subtract(x, y)
      - multiply(x, y)
      - divide(x, y)

      Throw
        - OverflowException if add(x, y) exceeds Int.MAX_VALUE
        - UnderflowException if subtract(x, y) exceeds Int.MIN_VALUE
        - MathCalculationException for division by Zero
  * */

  //  def infiniteLoop(n: Int): Int =
  //    @tailrec
  //    def infiniteUtil(nr: Int, acc: Int): Int = {
  //      if (nr <= 0) acc
  //      else infiniteUtil(nr - 1, acc + nr)
  //    }
  //    infiniteUtil(n, 1)
  //
  //  println(infiniteLoop(56))

  // 1. OOM implemented - OutOfMemoryError
  //  val array = Array.ofDim[Int](Int.MaxValue)

  // 2. SO - StackOverflowError
  //  def infinite: Int = 1 + infinite
  //  val noLimit = infinite

  class OverflowException extends RuntimeException

  class UnderflowException extends RuntimeException

  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

//  println(PocketCalculator.add(Int.MaxValue, 10))
//  println(PocketCalculator.subtract(-10, Int.MinValue))
//  println(PocketCalculator.multiply(10, Int.MinValue))
  println(PocketCalculator.divide(10, 0))
}
