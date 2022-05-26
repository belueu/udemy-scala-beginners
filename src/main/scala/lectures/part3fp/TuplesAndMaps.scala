package lectures.part3fp

import com.sun.media.sound.AbstractMidiDeviceProvider

import scala.annotation.tailrec

object TuplesAndMaps extends App {

  // tuples = finite ordered "lists"
  // max 22 parameters
  val aTuple = new Tuple2[Int, String](2, "Hello Scala") // (Int, String)
  val anotherTuple = Tuple2(3, "Hello Again")
  val thirdTuple = (4, "Hello there")

  println(thirdTuple)
  println(aTuple._1)
  println(aTuple._2)

  println(aTuple.copy(_2 = "Goodbye Java"))
  println(aTuple.swap) // swaps elements - only works for Tuples 2

  val aTupleOf4 = new Tuple4[Int, Int, Int, String](1, 2, 3, "Numbers")
  println(aTupleOf4)

  // Maps - keys -> values
  // Maps are immutable
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("Jim", 555), "Daniel" -> 789, ("JIM", 9000)).withDefaultValue(-1)
  // a -> b is sugar for (a, b)
  println(phoneBook)

  // map ops
  println(phoneBook.contains("Jim"))
  println(phoneBook("Mary"))

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhoneBook = phoneBook + newPairing

  println(newPhoneBook)

  // functionalism on maps
  // map, flatMap, filter

  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phoneBook.view.filterKeys(x => x.startsWith("J")).toMap)

  // mapValues
  println(phoneBook.view.mapValues(number => "0256-" + number * 10).toMap)

  // conversions to other collections
  println(phoneBook.toList)
  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Angela", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

  /*
    1. What will happen if I had two original entries "Jim" -> 555 and "JIM" -> 900
      when running println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))
      !!! -  Careful with mapping keys

    2. Overly simplified social network based on maps
      Person = String
       - add a person to the network
       - remove
       - friend (mutual)
       - unfriend (mutual)

      Stats:
       - number of friends of a person
       - person with th most friends
       - how many people have NO friends
       - if there is a social connection between two people (direct or not)
  * */

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }


  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")
  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unfriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(network, "Bob", "Mary"), "Bob"))

  // Jim, Bob, Mary
  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Bob", "Jim")
  val testNet = friend(jimBob, "Bob", "Mary")

  println(testNet)

  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if (!network.contains(person)) 0
    else network(person).size

  println(nFriends(testNet, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(testNet))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
    network.count(pair => pair._2.isEmpty) // network.count(_._2.isEmpty)

  println(nPeopleWithNoFriends(testNet))

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    @tailrec
    def bfs(target: String, consideredPeople: Set[String], discoverPeople: Set[String]): Boolean = {
      if (discoverPeople.isEmpty) false
      else {
        val person = discoverPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoverPeople.tail)
        else bfs(target, consideredPeople + person, discoverPeople.tail ++ network(person))
      }
    }

    bfs(b, Set(), network(a) + a)
  }

  println(socialConnection(testNet, "Mary", "Jim"))
  println(socialConnection(network, "Mary", "Bob"))
}
