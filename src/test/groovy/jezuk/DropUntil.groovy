package jezuk

import jezuk.mango.Mango
import jezuk.mango.Predicate

class DropUntil extends spock.lang.Specification {
  def "drop until 5 from 0"() {
    when:
      def t = buildRange([])
    then:
       t == []
  }
  def "drop until 5"() {
    when:
    def t = buildRange([1,2,3,4,5,6,7,8]);
    then:
    t == [5,6,7,8]
  }
  def "drop until5 from 5s"() {
    when:
      def t = buildRange([5,5,5,5,5,5]);
    then:
    t == [5,5,5,5,5,5]
  }
  def "drop until 5 from 9s"() {
    when:
      def t = buildRange([9,9,9,9,9]);
    then:
      t == []
  }

  private def isFive = new Predicate<Integer>() {
    public boolean test(Integer i) {
      return i == 5;
    }
  };

  private def buildRange(def a) {
    return Mango.from(a).dropUntil(isFive).toList();
  }

}
