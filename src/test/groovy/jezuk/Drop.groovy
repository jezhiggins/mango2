package jezuk

import jezuk.mango.Mango
import jezuk.mango.Predicate

class Drop extends spock.lang.Specification {
  def "drop tests"() {
    expect:
      Mango.from(list).drop(count).toList() == result

    where:
      list                  | count | result
      [1,2,3,4,5,6,7,8,9,0] |   5   | [6,7,8,9,0]
      [1,2,3]               |   5   | []
      [1,2,3,4,5]           |   5   | []
      []                    |   5   | []
      [1,2,3,4,5]           |   0   | [1,2,3,4,5]
      [1,2,3,4,5]           |   1   | [2,3,4,5]
  }

  def "dropWhile tests"() {
    def notFive = new Predicate<Integer>() {
       public boolean test(Integer i) { return i != 5; }
    }

    expect:
      Mango.from(list).dropWhile(notFive).toList() == result
    where:
      list                  | result
      []                    | []
      [1,2,3,4,5]           | [5]
      [1,2,3,4,5,6,7,8]     | [5,6,7,8]
      [5,5,5,5,5,5]         | [5,5,5,5,5,5]
      [9,9,9,9,9]           | []
      [9,9,9,9,9,5,8,8,8,8] | [5,8,8,8,8]
  }

  def "dropUntil tests"() {
    def isFive = new Predicate<Integer>() {
      public boolean test(Integer i) { return i == 5; }
    }

    expect:
      Mango.from(list).dropUntil(isFive).toList() == result
    where:
      list                  | result
      []                    | []
      [1,2,3,4,5]           | [5]
      [1,2,3,4,5,6,7,8]     | [5,6,7,8]
      [5,5,5,5,5,5]         | [5,5,5,5,5,5]
      [9,9,9,9,9]           | []
      [9,9,9,9,9,5,8,8,8,8] | [5,8,8,8,8]
  }
}