package lectures.part2oop

import sun.util.calendar.BaseCalendar.{Date, FRIDAY}

import java.time.Year

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAgeAtRelease())
  println(novel.currentAuthorAge())
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))

  val counter = new Counter

  counter.incrementCounter.incrementCounter.incrementCounter.print
  counter.decrementCounter(100).print

  println(counter.currentCount)
  counter.incrementCounter(10).print

}



/*
  Novel and Writer class
  Writer: firstName, surname, yearOfBirth
    - method getFullName
  Novel: name, yearOfRelease, author(instance of writer)
    - getAuthorAge
    - isWrittenBy(author)
    - copy (new year of release) = new instance of Novel
* */

/*
  Counter class
    - receives an int
    - method currentCount
    - method to increment/decrement that return a new counter
    - overload increment/decrement to receive a parameter - an amount of incr/decr
* */






