package jezuk

import jezuk.mango.Mango
import jezuk.mango.Predicate

class First extends spock.lang.Specification {
  def "take first"() {
    expect:
      Mango.from(s).first().toList() == result

    where:
      s           | result
      [1,2,3,4,5] | [1]
      [3]         | [3]
      []          | []
  } // take first

  def "drop then first"() {
    def notFive = new Predicate<Integer>() {
      public  boolean test(Integer i) { return i != 5; }
    } // notFive

    expect:
      Mango.from(list).dropWhile(notFive).first().toList() == result

    where:
      list           | result
      [1,2,3,4,5,6]  | [5]
      [5]            | [5]
      [5,4,3,2,1]    | [5]
  } // drop then first

  def "take then first"() {
    def notFive = new Predicate<Integer>() {
      public boolean test(Integer i) { return i != 5; }
    }

    expect:
      Mango.from(list).takeWhile(notFive).first().toList() == result

    where:
      list              | result
      [1,2,3,4,5,6,7,8] | [1]
      [9,9,9,99]        | [9]
      [5,5,5,5,4,6,7]   | []
  }
} // class First