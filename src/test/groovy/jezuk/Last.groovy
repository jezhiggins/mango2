package jezuk

import jezuk.mango.Mango
import jezuk.mango.Predicate

class Last extends spock.lang.Specification {
  def "take last"() {
    expect:
      Mango.from(s).last().toList() == result

    where:
      s           | result
      [1,2,3,4,5] | [5]
      [3]         | [3]
      []          | []
  } // take last

  def "drop then last"() {
    def notFive = new Predicate<Integer>() {
      public  boolean test(Integer i) { return i != 5; }
    } // notFive

    expect:
      Mango.from(list).dropWhile(notFive).last().toList() == result

    where:
      list           | result
      [1,2,3,4,5,6]  | [6]
      [5]            | [5]
      [5,4,3,2,1]    | [1]
      [1,2,3,4]      | []
      [5,5,5,5,4,6]  | [6]
      []             | []
  } // drop then last

  def "take then last"() {
    def notFive = new Predicate<Integer>() {
      public boolean test(Integer i) { return i != 5; }
    }

    expect:
      Mango.from(list).takeWhile(notFive).last().toList() == result

    where:
      list              | result
      [2]               | [2]
      [1,2,3,4,5,6,7,8] | [4]
      [9,9,9,99]        | [99]
      []                | []
      [5,5,5,5]         | []
  }
} // class Last