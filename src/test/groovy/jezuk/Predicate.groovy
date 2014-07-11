package jezuk

import jezuk.mango.Mango
import jezuk.mango.Predicate
import jezuk.mango.Predicates

class PredicateTest extends spock.lang.Specification {
  def "create and exercise a 'even integer' predicate"() {
    given:
      def predicate = new Predicate<Integer>() {
                       boolean test(Integer i) { return i % 2 == 0; }
                    };
    expect:
      predicate.test(x) == truth

    where:
      x << [0, 1, 2, 3, 4]
      truth << [true, false, true, false, true]
  }

  def "equal test"() {
    expect:
      Mango.from(list).where(Predicates.Equal(filter)).toList() == result

    where:
      list                    | filter  | result
      [1, 2, 3]               | 1       | [ 1 ]
      ['a', 'b', 'c']         | 'c'     | [ 'c' ]
      ["one", "two", "three"] | "two"   | [ "two" ]
      [1, 2, 3]               | 5       | [ ]
      ['c', 'a', 'b', 'c']    | 'c'     | [ 'c', 'c' ]
      ['c', null, 'b', 'c']   | null    | [ null ]
      [1, 2, 3]               | null    | [ ]
  }
}