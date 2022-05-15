package lectures.part2oop

class Counter(val count: Int = 0) {
  def currentCount = count

  def incrementCounter = {
    println("incrementing")
    new Counter(this.count + 1)
  }

  def decrementCounter = {
    println("decrementing")
    new Counter(this.count - 1)
  }

  def incrementCounter(amount: Int): Counter = {
    if (amount <= 0) this
    else incrementCounter.incrementCounter(amount - 1)
  }

  def decrementCounter(amount: Int): Counter = {
    if (amount <= 0) this
    else decrementCounter.decrementCounter(amount - 1)
  }

  def print = println(count)

}
