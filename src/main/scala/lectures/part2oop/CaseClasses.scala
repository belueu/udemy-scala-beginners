package lectures.part2oop

object CaseClasses extends App {

  /*
    equals, hashCode, toString
  * */

  case class Person(name: String, age: Int)

  // 1. class parameters are promoted to fields

  val jim = Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString for ease of debugging
  // println(instance) = println(instance.toString) // syntactic sugar
  println(jim)

  // 3. equals and hashCode implemented out-of-the-box
  val jim2 = Person("Jim", 34)
  println(jim == jim2)

  // 4. case classes have handy copy methods
  val jim3 = jim.copy(age = 45)
  println(jim3)
  println(jim == jim3)

  // 5. case classes have companion objects
  val thePerson = Person
  val mary = Person.apply("Mary", 23)
  println(mary)
  
  // 6. case classes are serializable
  // Akka
  
  // 7. case classes have extractor patterns == can be used in pattern matching
  
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }
  
  /*
    
  **/
}
