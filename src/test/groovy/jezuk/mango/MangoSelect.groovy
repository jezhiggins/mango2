package jezuk.mango

class MangoSelect extends spock.lang.Specification {
  def "uppercase"() {
    when:
      def upper = new Function<String, String>() {
        String apply(String s) { return s.toUpperCase(); }
      }
      def range = Mango.from(['one', 'two', 'three']).select(upper)

    then:
      range.hasNext() == true
      range.next() == 'ONE'
      range.hasNext() == true
      range.next() == 'TWO'
      range.hasNext() == true
      range.next() == 'THREE'
      range.hasNext() == false
  }

  def "string length"() {
    when:
    def len = new Function<String, Integer>() {
        Integer apply(String s) { return s.length(); }
      }
      def range = Mango.from(['one', 'two', 'three']).select(len)

    then:
      range.hasNext() == true
      range.next() == 3
      range.hasNext() == true
      range.next() == 3
      range.hasNext() == true
      range.next() == 5
      range.hasNext() == false
  }


}