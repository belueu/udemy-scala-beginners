package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): BigInt = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = factorial(n - 1) * n
      println("Computed factorial of " + n)
      result
    }
  }

  println(factorial(10))
  //  println(factorial(10000))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)
    }

    factHelper(n, 1)
  }
  /*
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10 * 1)
    = factHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factHelper(2, 3 * 4 * ... * 10 * 1)
    = factHelper(1, 2 * 3 * ... * 10 * 1)
    = 1 * 2 * 3 * ... * 10
  * */

  println(anotherFactorial(10))

  /*
    1. Concatenate a string n times using tail recursion
    2. Is prime function using tail recursion
    3. Fibonacci function using tail recursion
  * */

  // 1. String concatenation
  @tailrec
  def stringConcatenation(s: String, n: Int, accumulator: String = ""): String = {
    if (n <= 1) accumulator + s
    else stringConcatenation(s, n - 1, accumulator + s)
  }

  println(stringConcatenation("hello", 1000))

  def anotherStringConcatenation(string: String, number: Int): String = {
    @tailrec
    def stringConcatUtil(s: String, n: Int, acc: String): String = {
      if (n <= 1) acc + s
      else stringConcatUtil(s, n - 1, acc + s)
    }

    stringConcatUtil(string, number, "")
  }

  println(anotherStringConcatenation("yam", 1000))

  // 2. Is prime
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)
    }
    isPrimeTailRec(n / 2 , true)
  }

  println(isPrime(2003))
  println(isPrime(49))

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciTailRec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fibonacciTailRec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fibonacciTailRec(2, 1, 1)
  }

  println(fibonacci(5))
  println(fibonacci(8))


}
