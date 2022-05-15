package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  //  println(aParameterlessFunction) - this does not work in scala 3

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION.
  // Compiler can infer return types of functions if the function is not recursive

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  aFunctionWithSideEffects("Boo")

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  println(aBigFunction(5))

  /*
    1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
    2. Factorial function 1 * 2 * 3 * ... * n - recursive function
    3. Fibonacci function
      f(1) = 1
      f(2) = 1
      f(n) = f(n-1) + f(n-2)
    4. Test if a number is prime function
  * */

  // 1. Greeting function implementation
  def greeting(name: String, age: Int): String =
    s"Hi, my name is $name and I am $age years old."

  println(greeting("David", 12))

  // 2. Factorial function recursive implementation
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  // 2. Factorial function tail recursive implementation
  def factTailRec(n: Int): BigInt = {
    @tailrec
    def factTailUtil(n: Int, acc: BigInt): BigInt = {
      if (n <= 1) acc
      else factTailUtil(n - 1, acc * n)
    }

    if (n <= 0) 1
    else factTailUtil(n, 1)
  }

  println(s"The result of factorial function recursive implementation is: ${factorial(9)}")
  println(s"The result of factorial function tail recursive implementation is: ${factorial(9)}")

  // 3. Fibonacci function recursive implementation
  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  // 3. Fibonacci function tail recursive implementation
  def fibonacciTailRec(n: Int): BigInt = {
    @tailrec
    def fibonacciTailRecUtil(n: Int, acc: BigInt): BigInt = {
      if (n <= 2) acc
      else fibonacciTailRecUtil(n - 1, acc)
    }
    if (n <= 0) 0
    else fibonacciTailRecUtil(n, 1)
  }

  println(s"The result of fibonacci function recursive implementation is: ${fibonacci(30)}")
  println(s"The result of fibonacci function tail recursive implementation is: ${fibonacciTailRec(45)}")

  // 4. Test is prime function recursive implementation
  // 4. Test is prime function tail recursive implementation
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t -1)
    }
    isPrimeUntil(n / 2)
  }

  println(s"The result of is prime function 'recursive/tail recursive' implementation is: ${isPrime(2025)}")
}
