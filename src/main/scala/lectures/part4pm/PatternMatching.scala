package lectures.part4pm

import com.sun.org.apache.xerces.internal.impl.dv.xs.AnyURIDV
import com.sun.org.apache.xpath.internal.Expression
import jdk.nashorn.internal.runtime.PrototypeObject

import scala.util.Random

object PatternMatching extends App {

  // switch on steroids
  val random = new Random()
  val x = random.nextInt(10)

  val description = x match
    case 1 => "the One"
    case 2 => "double or nothing"
    case 3 => "third time is the charm"
    case _ => "something else" // _ = WILDCARD (it will match anything)

  println(x)
  println(description)

  // 1. Decompose values
  case class Person(name: String, age: Int)

  val bob = new Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi my name is $n, and I can't drink in the US"
    case Person(n, a) => s"Hi my name is $n, and I am $a years old"
    case _ => "I don't know who I am"
  }
  println(greeting)

  /*
    1. cases are matched in order
    2. what if no cases match? => MatchError
    3. type of the pattern match expression? => unified type of the types in all the cases
    4. Pattern Matching works really well with case classes
  * */

  // Pattern Matching on sealed hierarchies
  sealed class Animal

  case class Dog(bread: String) extends Animal

  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")

  animal match {
    case Dog(someBread) => println(s"Matched a dog of the $someBread breed")
  }

  // match everything
  val isEven = x match
    case n if n % 2 == 0 => true
    case _ => false

  //WHY?
  val isEvenCond = if (x % 2 == 0) true else false // ?!
  val isEvenNormal = x % 2 == 0

  /*
    Exercise:
      Create a simple function that uses Pattern Matching,
      takes and Expr => human readable form i.e.
          Sum(Number(2), Number(3)) => 2 + 3
          Sum(Sum(Number(2), Number(3)), Number(4)) => 2 + 3 + 4
          Product(Sum(Number(2), Number(1)), Number(3)) => (2 + 1) * 3
          Sum(Prod(Number(2), Number(1)), Number(3)) => 2 * 1 + 3
  * */

  trait Expr

  case class Number(n: Int) extends Expr

  case class Sum(e1: Expr, e2: Expr) extends Expr

  case class Product(e1: Expr, e2: Expr) extends Expr

  def show(expression: Expr): String = expression match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => s"${show(e1)} + ${show(e2)}"
    case Product(e1, e2) => {
      def maybeShowParentheses(expr: Expr) = expr match
        case Product(_, _) => show(expr)
        case Number(_) => show(expr)
        case _ => s"(${show(expr)})"

      s"${maybeShowParentheses(e1)} * ${maybeShowParentheses(e2)}"
    }
  }

  println(show(Number(Random.nextInt(10))))
  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Product(Sum(Number(2), Number(1)), Number(3))))
  println(show(Sum(Product(Number(2), Number(1)), Number(3))))
}
