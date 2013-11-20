package jezuk.mango

class MangoWhere extends spock.lang.Specification {
  def "filter a list"() {
    when:
      def findTwo = new Predicate<String>() {
        boolean test(String s) { return 'two' == s; }
      }
      def range = Mango.from(['one', 'two', 'three']).where(findTwo)

    then:
      range.hasNext() == true
      range.next() == 'two'
      range.hasNext() == false
  }

  def "filter everything"() {
    when:
      def nothing = new Predicate<String>() {
        boolean test(String s) { return false; }
      }
      def range = Mango.from(['one', 'two', 'three']).where(nothing)

    then:
      range.hasNext() == false
  }

  def "filter nothing"() {
    when:
      def everything = new Predicate<String>() {
        boolean test(String s) { return true; }
      }
      def range = Mango.from(['one', 'two', 'three']).where(everything)

    then:
      range.hasNext() == true
      range.next() == 'one'
      range.hasNext() == true
      range.next() == 'two'
      range.hasNext() == true
      range.next() == 'three'
      range.hasNext() == false
  }
}