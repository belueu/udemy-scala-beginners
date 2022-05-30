package lectures.part4pm

object PatternEverywhere extends App {

  // Big idea #1
  try {
    // code
  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "null pointer"
    case _ => "something else"
  }

  // catches are actually MATCHES
  /*
    try {
      // code
    } catch (e) {
      e match {
        case e: RuntimeException => "runtime"
        case npe: NullPointerException => "null pointer"
        case _ => "something else"
      }
    }
  * */

  // Big idea #2
  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0 // !?
  } yield 10 * x

  // generators are also based o PATTERN MATCHING
  val tuples = List((1, 2), (3, 4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second
  // case classes, :: operators ...

  println(tuples)
  println(filterTuples)

  // Big idea #3
  val tuple = (1, 2, 3)
  val (a, b, c) = tuple
  println(b)
  // multiple value definition based on PATTERN MATCHING
  // ALL THE POWER IS AVAILABLE

  val head :: tail = list
  println(head)
  println(tail)

  // Big idea #4
  // partial function are based on PATTERN MATCHING
  val mappedList = list.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "something else"
  } // partial function literal ^^^ - advanced

  // equivalent ^^^
  val mappedList2 = list.map { x =>
    x match
      case v if v % 2 == 0 => v + " is even"
      case 1 => "the one"
      case _ => "something else"
  }

  println(mappedList)
  println(mappedList2)

}
