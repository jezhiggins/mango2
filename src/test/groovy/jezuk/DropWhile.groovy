package jezuk

import jezuk.mango.Mango
import jezuk.mango.Predicate

class DropWhile extends spock.lang.Specification {
  def "drop while !5 from 0"() {
    when:
      def t = buildRange([])
    then:
       t == []
  }
  def "drop while !5 from 5"() {
    when:
      def t = buildRange([1,2,3,4,5,6,7,8]);
    then:
    t == [5,6,7,8]
  }
  def "drop while !5 from 5s"() {
    when:
      def t = buildRange([5,5,5,5,5,5]);
    then:
    t == [5,5,5,5,5,5]
  }
  def "drop while !5 from 9s"() {
    when:
      def t = buildRange([9,9,9,9,9]);
    then:
      t == []
  }
  def "drop while !5 from 5s and 9s"() {
    when:
      def t = buildRange([9,9,9,9,5,8,8,8,8])
    then:
      t == [5,8,8,8,8]
  }
  private def notFive = new Predicate<Integer>() {
    public boolean test(Integer i) {
      return i != 5;
    }
  };

  private def buildRange(def a) {
    return Mango.from(a).dropWhile(notFive).toList();
  }

}
