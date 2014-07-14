package jezuk

import jezuk.mango.Mango
import jezuk.mango.Predicate

class Match extends spock.lang.Specification {
  def "all match test"() {
    expect:
    Mango.from(list).allMatch(new Predicate<Integer>() {
      public boolean test(Integer i) {
        return i > 5;
      }
    }) == result

    where:
      list                  | result
      [1,2,3,4,5,6,7,8,9,0] | false
      [1,2,3]               | false
      [1,2,3,4,5]           | false
      []                    | false
      [6,7,8,9,10]          | true
      [6]                   | true
      [6,6,6,6,6,6,6,6,6,6] | true
      [6,6,6,6,6,6,6,6,6,0] | false
  }

  def "any match test"() {
    expect:
    Mango.from(list).anyMatch(new Predicate<Integer>() {
      public boolean test(Integer i) {
        return i > 5;
      }
    }) == result

    where:
      list                  | result
      [1,2,3,4,5,6,7,8,9,0] | true
      [1,2,3]               | false
      [1,2,3,4,5]           | false
      []                    | false
      [6,7,8,9,10]          | true
      [6]                   | true
      [6,6,6,6,6,6,6,6,6,6] | true
      [6,6,6,6,6,6,6,6,6,0] | true
      [0,0,0,0,0,0,0,0,6,0] | true
  }
}
