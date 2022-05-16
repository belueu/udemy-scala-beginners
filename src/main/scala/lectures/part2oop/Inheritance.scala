package lectures.part2oop

object Inheritance extends App {


  // single class inheritance
  sealed class Animal {
    val creatureType = "wild"
    def eat(): Unit = println("nomnomnom")
  }

  class Cat extends Animal {
    def crunch(): Unit = {
      eat()
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch()

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType = "domestic"
    override def eat(): Unit = {
      println("crunch, crunch")
      super.eat()
    }
  }

  val dog = new Dog("K9")
  dog.eat()
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat()

  // OVERRIDING VS OVERLOADING

  // super

  // preventing overrides
  // 1 - use final on member
  // 2 - use final on class
  // 3 - seal the class = extend classes in the same file and prevents extension in other files

}
