package exercises

import scala.annotation.targetName

abstract class MyList[+A] {

  /*
    head = first element of the list
    tail = remainder of the list
    isEmpty = ist this list empty
    add(int) => new list with this element added
    toString => a string representation of the list
  * */

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  // polymorphic call
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): MyList[B]

  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]

  def filter(predicate: MyPredicate[A]): MyList[A]

  // concatenation
  @targetName("++")
  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException()

  override def tail: MyList[Nothing] = throw new NoSuchElementException()

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""

  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty

  override def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  @targetName("++")
  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String = {
    if (t.isEmpty) "" + h
    else s"$h ${t.printElements}"
  }

  /*
    [1, 2, 3].filter(n % 2 == 0)
      = [2, 3].filter(n % 2 == 0)
      = new Cons(2, [3].filter(n % 2 == 0))
      = new Cons(2, Empty.filter(n % 2 == 0))
      = new Cons(2, Empty)
  * */
  override def filter(predicate: MyPredicate[A]): MyList[A] =
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)


  /*
    [1, 2, 3].map(n * 2)
      = new Cons(2, [2, 3].map(n * 2))
      = new Cons(2, new Cons(4, [3].map(n * 2)))
      = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
      = new Cons(2, new Cons(4, new Cons(6, Empty)))
  * */
  override def map[B](transformer: MyTransformer[A, B]): MyList[B] =
    new Cons(transformer.transform(h), t.map(transformer))


  /*
    [1, 2] ++ [3, 4, 5]
      = new Cons(1, [2] ++ [3, 4, 5])
      = new Cons(1, new Cons(2, Empty ++ [3, 4, 5]))
      = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5, Empty)))))
  * */
  @targetName("++")
  override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons[B](h, t ++ list)

  /*
    [1, 2].flatMap(n => [n, n + 1])
      = [1, 2] ++ [2].flatMap(n => [n, n + 1])
      = [1, 2] ++ [2, 3] ++ Empty.flatMap(n => [n, n + 1])
      = [1, 2] ++ [2, 3] ++ Empty
      = [1, 2, 2, 3]
  * */
  override def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)

}

trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}

object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, Empty)))
  val clonedListOfIntegers: MyList[Int] = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons[Int](4, new Cons[Int](5, Empty))
  val listOfStrings: MyList[String] = new Cons[String]("hello", new Cons[String]("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
  println(listOfIntegers.map((elem: Int) => elem * 2).toString)
  println(listOfIntegers.filter((elem: Int) => elem % 3 == 0).toString)

  println((listOfIntegers ++ anotherListOfIntegers).toString)
  println(listOfIntegers.flatMap((elem: Int) => new Cons[Int](elem, new Cons[Int](elem + 1, Empty))).toString)

  println(clonedListOfIntegers == listOfIntegers)
}