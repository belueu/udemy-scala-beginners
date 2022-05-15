package lectures.part2oop

// age is a class parameter and NOT a class member (Field)
// constructor
class Person(name: String, val age: Int = 0) {
  // body contains
  // val and var definitions
  // functions or methods
  val x = 2
  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // Multiple constructors
  def this(name: String) = this(name, 0)

  def this() = this("John Doe")
}
