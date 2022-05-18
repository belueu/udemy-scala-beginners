package lectures.part2oop

import playground.{Cinderella => Princess, PrintCharming}
import java.util.{Date => JavaDate}
import java.sql.{Date => SqlDate}


object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2022)

  // import the package
  val princess = new Princess // playground.Cinderella = fully qualified name

  // packages are structured in hierarchy
  // matching folder structure in the file system

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrintCharming

  // 1. Use fully qualified name
  val date = new java.util.Date()
  val sqlDate = new java.sql.Date(2018)

  // 2. Use aliases
  val javaDate = new JavaDate()
  val dbDate = new SqlDate(0).toLocalDate.plusYears(52).plusMonths(4).plusDays(17)
  println(dbDate)
  println(javaDate)

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???

}
