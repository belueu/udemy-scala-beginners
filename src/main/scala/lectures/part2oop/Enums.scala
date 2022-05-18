package lectures.part2oop

object Enums {

  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    // add fields/methods
    def openDocument(): Unit =
      if (this == READ) println("Opening doc")
      else println("Not allowed")
  }

  val somePermissions: Permissions = Permissions.READ

  // enums can take constructor arguments
  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4) // 100
    case WRITE extends PermissionsWithBits(2) // 010
    case EXECUTE extends PermissionsWithBits(1) // 001
    case NONE extends PermissionsWithBits(0) // 000
  }

  object PermissionsWithBits {
    def fromBits(bits: Int): PermissionsWithBits =
      PermissionsWithBits.NONE
  }

  // standard API for Enums
  val somePermissionsOrdinal: Int = somePermissions.ordinal
  val allPermissions: Any = PermissionsWithBits.values // array of all possible values of the enum
  val readPermission: Permissions = Permissions.valueOf("READ") // Permissions.READ



  def main(args: Array[String]): Unit = {
    println(somePermissions)
    somePermissions.openDocument()

    println(somePermissionsOrdinal)
    println(readPermission)

  }

}
