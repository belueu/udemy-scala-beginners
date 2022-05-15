package lectures.part2oop

import java.time.Year

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def currentAuthorAge(): Int = Year.now().getValue - author.yearOfBirth // author current age

  def authorAgeAtRelease(): Int = yearOfRelease - author.yearOfBirth

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(newYearOfRelease: Int): Novel = new Novel(this.name, newYearOfRelease, this.author)
}
