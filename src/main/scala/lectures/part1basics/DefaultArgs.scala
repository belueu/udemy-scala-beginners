package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def tailRecFact(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else tailRecFact(n - 1, n * acc)
  }

  val factOf10 = tailRecFact(10)
  println(factOf10)

  val factOf10Times2 = tailRecFact(10, 2)
  println(factOf10Times2)

  def savePicture(format: String = "jpeg", width: Int = 1920, height: Int = 1080): Unit =
    println(s"saving picture with: format = $format, width = $width and height = $height")

  savePicture()
  savePicture(height = 1366)
  savePicture(width = 800)
  savePicture("png")
  savePicture(format = "jpg")
  savePicture(height = 1900, width = 3600, format = "xxl")
  /*
    1. Pass in every leading argument
    2. Name the arguments
  * */
}
