package jezuk

import jezuk.mango.Mango
import jezuk.mango.Predicate

class LastWhere extends spock.lang.Specification {
  def "filter a list"() {
    when:
      def findTwo = new Predicate<String>() {
        boolean test(String s) { return 'two' == s; }
      }
      def range = Mango.from(['one', 'two', 'three', 'two']).lastWhere(findTwo)

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
      def range = Mango.from(['one', 'two', 'three']).lastWhere(nothing)

    then:
      range.hasNext() == false
  }

  def "filter nothing"() {
    when:
      def everything = new Predicate<String>() {
        boolean test(String s) { return true; }
      }
      def range = Mango.from(['one', 'two', 'three']).lastWhere(everything)

    then:
      range.hasNext() == true
      range.next() == 'three'
      range.hasNext() == false;
  }

  def "filter and filter"() {
    when:
      def lengthIs3 = new Predicate<String>() {
        boolean test(String s) { return s.length() == 3; }
      }
      def beginsWithT = new Predicate<String>() {
        boolean test(String s) { return s.charAt(0) == 't'; }
      }
      def range = Mango.from(['three', 'two', 'one']).
                       lastWhere(lengthIs3).
                       lastWhere(beginsWithT);

      def range2 = Mango.from(['one', 'two', 'three', 'tum']).
                       lastWhere(beginsWithT).
                       lastWhere(lengthIs3);

    then:
      range.hasNext() == false
      range2.hasNext() == true
      range2.next() == 'tum'
      range2.hasNext() == false
  }
}