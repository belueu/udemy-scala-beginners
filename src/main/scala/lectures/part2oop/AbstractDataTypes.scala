package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val creatureType: String

    def eat(): Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    override def eat(): Unit = println("crunch crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit

    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Salt water crocodile"

    override def eat(): Unit = println("chaw chaw")

    override def eat(animal: Animal): Unit = println(s"I'm a crocodile and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val crocodile = new Crocodile

  crocodile.eat(dog)

  // Traits vs Abstract classes
  // 1. Traits cannot have constructor parameters
  // 2. multiple traits may be inherited by the same class
  // 3. traits resemble behaviour while abstract classes describe a thing
}
