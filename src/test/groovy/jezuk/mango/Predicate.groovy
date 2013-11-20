package jezuk.mango

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
}