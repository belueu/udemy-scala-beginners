package lectures.part2oop

import scala.annotation.targetName
import scala.language.postfixOps

object Notations extends App {

  class Person(val name: String, favoriteMovie: String) {

    def likes(movie: String): Boolean = movie == favoriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"$name, what the heck?"

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"


  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))

  // infix notation, operator notation (syntactic sugar)
  println(mary likes "Inception")

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))
  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS
  // Akka actors have ! ? operators

  // prefix notation
  val x = -1 // equivalent with 1.unary_
  val y = 1.unary_-
  // unary_ prefix works only with - + ~ !
  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary())
}
