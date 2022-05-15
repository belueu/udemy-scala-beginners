package lectures.part2oop

class Writer(firstName: String, surname: String, val yearOfBirth: Int) {
  def fullName(): String = s"$firstName $surname"

}
