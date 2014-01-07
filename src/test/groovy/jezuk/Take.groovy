package jezuk

import jezuk.mango.Mango
import jezuk.mango.Predicate

class Take extends spock.lang.Specification {
  def "take tests" () {
    expect:
      Mango.from(s).take(n).toList() == result

    where:
      s                     | n  | result
      [1,2,3,4,5,6,7,8,9,0] | 5  | [1,2,3,4,5]
      [1,2,3]               | 5  | [1,2,3]
      [1,2,3,4,5]           | 5  | [1,2,3,4,5]
      []                    | 5  | []
      [1,2,3,4,5]           | 0  | []
      [1,2,3,4,5]           | 1  | [1]
  }

  def "takeWhile tests"() {
    def notFive = new Predicate<Integer>() {
      public boolean test(Integer i) { return i != 5; }
    }

    expect:
    Mango.from(list).takeWhile(notFive).toList() == result

    where:
      list              | result
      []                | []
      [1,2,3,4,5,6,7,8] | [1,2,3,4]
      [5,5,5,5,5,5]     | []
      [9,9,9,99]        | [9,9,9,99]
  }

  def "takeUntil tests"() {
    def isFive = new Predicate<Integer>() {
      public boolean test(Integer i) { return i == 5; }
    }

    expect:
      Mango.from(list).takeUntil(isFive).toList() == result

    where:
      list              | result
      []                | []
      [1,2,3,4,5,6,7,8] | [1,2,3,4]
      [5,5,5,5,5,5]     | []
      [9,9,9,99]        | [9,9,9,99]
  }
}