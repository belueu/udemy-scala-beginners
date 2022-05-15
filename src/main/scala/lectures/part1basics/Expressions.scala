package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // expression
  println(x)

  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= ... side effects
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 // if expression, not if instruction
  println(aConditionedValue)
  println(if (aCondition) 5 else 3)
  println(1 + 3)

  // NEVER write this again
  var i = 0
  val aWhile = while (i < 10) {
    println(i)
    i += 1
  }

  // EVERYTHING IN SCALA IS AN EXPRESSION !

  val aWierdValue = (aVariable = 3) // Unit === void
  println(aWierdValue)

  // side effects: println(), whiles, reassigning

  // Code blocks

  // A code block is an expression
  // Value of the code block is === with the last expression in the block
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  // 1. What is the difference between "hello world" and println("hello world")
      // "hello world" - String type and println("hello world") - Unit type
  // 2. What is the value of the code bellow
      // First block: true
      // Second block 42

  val someValue = {
    2 < 3
  }
  println(someValue)

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }
  println(someOtherValue)

}
