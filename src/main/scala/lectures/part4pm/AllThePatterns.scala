package lectures.part4pm

import exercises.{Cons, Empty, MyList}

object AllThePatterns extends App {

  // 1. Constants
  val x: Any = "Scala"
  val constants = x match
    case 1 => "a number"
    case "Scala" => "THE Scala"
    case true => "The Truth"
    case AllThePatterns => "A singleton object"

  // 2. Match anything
  // 2.1 Wildcard

  val matchAnything = x match
    case _ =>

  // 2.2 Variable
  val matchAVariable = x match
    case something => s"I've found $something"

  // 3. Tuples
  val aTuple = (1, 2)
  val matchATuple = aTuple match
    case (1, 1) =>
    case (something, 2) => s"I've found $something"

  val nestedTuple = (1, (2, 3))
  val matchANestedTuple = nestedTuple match
    // Pattern matches can be NESTED
    case (_, (2, v)) =>

  // 4. Case classes - Constructor pattern
  // Pattern matching can be nested with case classes as well
  val myList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList = myList match
    case Empty =>
    case Cons(head, Cons(subhead, subtail)) =>

  // 5. List patterns
  val aStandardList = List(1, 2, 3, 42)
  val standardListMatching = aStandardList match
    case List(1, _, _, _) => // extractor for list - advanced
    case List(1, _ *) => // list of arbitrary length - advanced
    case 1 :: List(_) => // infix pattern
    case List(1, 2, 3) :+ 42 => // infix pattern

  // 6. Type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match
    case list: List[Int] => // explicit type specifier
    case _ =>

  // 7. Name binding
  val nameBindingMatch = myList match
    case nonEmptyList@Cons(_, _) => // name binding => use the name later(here)
    case Cons(1, rest@Cons(2, _)) => // name binding inside nested patterns

  // 8. Multi-patterns
  val multiPattern = myList match
    case Empty | Cons(0, _) => // compound pattern (multi-pattern)
    case _ =>

  // 9. If guards
  val secondElementSpecial = myList match
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 =>

  // All

  /*
    Question -> Response: 'list of numbers' but the correct answer is 'a list of strings'
    Why? -> Short answer: Type erasure by the JVM to ensure backwards compatibility
  * */

  val numbers = List(1, 2, 3)
  val numbersMatch = numbers match
    case listOfStrings: List[String] => "a list of strings"
    case listOfNumbers: List[Int] => "a list of numbers"
    case _ => ""

  println(numbersMatch)
}
