package lectures.part4pm

object BracelessSyntax {

  // if - expressions
  val anIfExpression = if (2 > 3) "bigger" else "smaller"

  // java-style
  val anIfExpression_v2 =
    if (2 > 3) {
      "bigger"
    } else {
      "smaller"
    }

  // compact style
  val anIfExpression_v3 =
    if (2 > 3) "bigger"
    else "smaller"

  // In scala 3
  val anIfExpression_v4 =
    if 2 > 3 then
      "bigger" // higher indentation than the if part
    else
      "smaller"

  val anIfExpression_v5 =
    if 2 > 3 then
      val result = "bigger"
      result
    else
      val result = "smaller"
      result

  // scala 3 one-liner
  val anIfExpression_v6 = if 2 > 3 then "bigger" else "smaller"

  // for-comprehensions
  val aForComprehension = for {
    n <- List(1, 2, 3)
    s <- List("black", "white")
  } yield s"$n$s"

  // scala 3 style
  val aForComprehension_v2 =
    for
      n <- List(1, 2, 3)
      s <- List("black", "white")
    yield s"$n$s"


  // Pattern Matching
  val meaningOfLife = 42
  val aPatternMatch = meaningOfLife match {
    case 1 => "the one"
    case 2 => "double or nothing"
    case _ => "something else"
  }

  // scala 3 style
  val aPatternMatch_v2 =
    meaningOfLife match
      case 1 => "the one"
      case 2 => "double or nothing"
      case _ => "something else"

  def computeMeaningOfLife(arg: Int): Int = {
    val partialResult = 40

    // code ....
    partialResult + 2
  }

  // class definition with significant indentation (same for traits, objects, enums etc)
  class Animal: // the compiler expects the body of Animal
    def eat(): Unit =
      println("I'm eating")
    end eat


    def grow(): Unit =
      println("I'm growing")
    end grow

    // 3000 more lines of code

  end Animal // for if, match, for, classes, traits, enums, objects, methods etc...


  // anonymous classes
  val aSpecialAnimal = new Animal:
    override def eat(): Unit = println("I'm special")

  // indentation = strictly larger indentation
  // 3 spaces + 2 tabs > 2 spaces + 2 tabs
  // 3 spaces + 2 tabs > 3 spaces + 1 tab
  // 3 tabs + 2 spaces ??? 2 tabs + 3 spaces
  // Conclusion: USE Spaces or tabs - DON'T MIX

  def main(args: Array[String]): Unit = {
    println(anIfExpression_v5)
    println(computeMeaningOfLife(72))
  }
}
