package lectures.part3fp

object WhatsAFunction extends App {

  // DREAM: use and work with functions as first class elements
  // problem: oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(elem: Int): Int = elem * 2
  }

  println(doubler(2))

  // function types = Function1[A, B]
  val aStringToIntConverter = new Function1[String, Int]:
    override def apply(v1: String): Int = v1.toInt

  println(aStringToIntConverter("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int]:
    override def apply(v1: Int, v2: Int): Int = v1 + v2

  // Function types Function2[A, B, R] === (A, B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS

  /*
    1. Define a function which takes 2 strings and concatenates them
    2. transform the MyPredicate and MyTransformer into function types
    3. Define a function which take an Int and returns another function which takes an int and returns an Int
      - what's the type of this function
      - how to do it
  * */

  // 1.
  val concat: (String, String) => String = new Function2[String, String, String]:
    override def apply(a: String, b: String): String = a + b
  println(concat("John ", "Doe"))

  // Function1[Int, Function1[Int, Int]]

  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4)) // curried function


  trait MyFunction[A, B] {
    def apply(elem: A): B
  }
}

