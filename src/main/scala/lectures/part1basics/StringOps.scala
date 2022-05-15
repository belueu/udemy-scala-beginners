package lectures.part1basics

object StringOps extends App {

  val aString: String = "Hello, I am learning Scala"

  // Returns the character at index 2 which is 'l'
  println(aString.charAt(2))

  // Returns a value string from index 7 inclusive to 11 not inclusive [7, 11) (7, 8, 9, 10)
  println(aString.substring(7, 11))
  println(aString.split(" ").toList)
  println(aString.startsWith("Hello"))
  val modifiedString = aString.replace(" ", "-")
  println(modifiedString)
  val modifiedStringSecondTime = modifiedString.replace(",", "")
  println(modifiedStringSecondTime)
  println(aString.toUpperCase())
  println(aString.toLowerCase())
  println(aString.length)

  val numberString = "2"
  val aNumber = numberString.toInt
  println('a' +: numberString :+ 'z')
  println(aString.reverse)
  println(aString.take(2))

  // Scala-specific: String interpolation

  // S-interpolation
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name, and I am $age years old."
  println(greeting)

  val anotherGreeting = s"Hello, my name is $name, and I will be turning ${age + 1} years old."
  println(anotherGreeting)

  // F-interpolation
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  println(myth)

  // Raw-interpolation
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")
}
