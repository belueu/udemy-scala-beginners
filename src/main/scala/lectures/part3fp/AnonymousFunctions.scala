package lectures.part3fp

object AnonymousFunctions extends App {

  // anonymous function (LAMBDA)
  val doubler = (x: Int) => x * 2

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val message: () => String = () => s"Hello there, this is yours truly 🥰 Scala!"

  // !⚠ WARNING
  println(message) // the actual function
  println(message()) // the function call

  // curly braces with lambda
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MORE syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b

  /*
    1. MyList: replace all FunctionX calls with lambdas
    2. Define /Rewrite the "special" adder as an anonymous function
  * */

  // 2.
  val specialAdder = (x: Int) => (y: Int) => x + y

  println(specialAdder(2)(5))

}
