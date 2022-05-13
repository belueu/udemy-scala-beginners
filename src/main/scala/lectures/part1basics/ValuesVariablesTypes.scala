package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x: Int = 42
  println(x)

  // VAL's are IMMUTABLE
  //  x = 2

  // Type inference at compile time, no need to specify
  val y = 22

  val aString: String = "hello"
  val anotherString: String = "goodbye"
  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x // represented on 4 bytes
  val aShort: Short = 4613 // represented on 2 bytes
  val aLong: Long = 12323232312323L // represented on 8 bytes
  val aFloat: Float = 2.0f // represented as 4 bytes
  val aDouble: Double = 3.141 // represented as 8 bytes

  // variables
  var aVariable: Int = 4

  // Variables can be reassigned
  aVariable = 5 // side effects


}
