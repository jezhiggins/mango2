package jezuk.mango

class WhereSelect extends spock.lang.Specification {
  def "filter and upper case"() {
    when:
      def beginsWithT = new Predicate<String>() {
        boolean test(String s) { return s[0] == 't'; }
      }
      def upper = new Function<String, String>() {
        String apply(String s) { return s.toUpperCase(); }
      }
      def range = Mango.from(['one', 'two', 'three']).where(beginsWithT).select(upper)

    then:
      range.hasNext() == true
      range.next() == 'TWO'
      range.hasNext() == true
      range.next() == 'THREE'
      range.hasNext() == false
  }
}
