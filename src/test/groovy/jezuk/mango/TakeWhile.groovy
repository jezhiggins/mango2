package jezuk.mango;

class TakeWhile extends spock.lang.Specification {
  def "take until 5 from 0"() {
    when:
      def t = buildRange([])
    then:
       t == []
  }
  def "take until 5 from 5"() {
    when:
    def t = buildRange([1,2,3,4,5,6,7,8]);
    then:
      t == [1,2,3,4]
  }
  def "take until 5 from 5s"() {
    when:
      def t = buildRange([5,5,5,5,5,5]);
    then:
      t == []
  }
  def "take until 5 from 9s"() {
    when:
      def t = buildRange([9,9,9,9,9]);
    then:
      t == [9,9,9,9,9]
  }

  private def notFive = new Predicate<Integer>() {
    public boolean test(Integer i) {
      return i != 5;
    }
  };

  private def buildRange(def a) {
    return Mango.from(a).takeWhile(notFive).toList();
  }

}
