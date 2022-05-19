package lectures.part3fp

object MapFlatMapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  // map
  println(list.map((x: Int) => x + 1))
  println(list.map(_ + 1)) // syntactic sugar
  println(list.map((x: Int) => x + " is a number"))
  println(list.map(_ + " is a number")) // syntactic sugar

  // filter
  println(list.filter((x: Int) => x % 2 == 0))
  println(list.filter(_ % 2 == 0)) // syntactic sugar

  // flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  // print all combinations between 2 lists
  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  // List("a1", "a2", ..., "d4")
  val colors = List("black", "white")

  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combinations)
  println(numbers.flatMap(n => chars.map(c => "" + c + n)))


  // "iterations"
  val allCombs = numbers.flatMap(n => chars.flatMap(c => colors
      .map(co => "" + c + n + "-" + co)))
  println(allCombs)

  // foreach
  list.foreach(println)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0 // equivalent to numbers.filter(_ % 2 == 0).flatMap(n => chars.flatMap(c => colors.map(co => "" + c + n + "-" + co)))
    c <- chars
    co <- colors
  } yield "" + c + n + "-" + co

  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  // syntax overload
  val duplicate = list.map { x =>
    x * 2
  }
  println(duplicate)

  /*
    1. MyList supports for-comprehensions?
        map(f: A => B) => MyList[B]
        filter(p: A => Boolean) => MyList[A]
        flatMap(f: A => MyList[B]) => MyList[B]
    2. Implemented a small collection of at most ONE element - Maybe[+T]
        - map, flatMap, filter
  * */
  
  
}
