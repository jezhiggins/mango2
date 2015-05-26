package jezuk

import jezuk.mango.Mango
import jezuk.mango.Predicate

class MangoFirstWhere extends spock.lang.Specification {
  def "filter a list"() {
    when:
      def findTwo = new Predicate<String>() {
        boolean test(String s) { return 'two' == s; }
      }
      def range = Mango.from(['one', 'two', 'three', 'two']).firstWhere(findTwo)

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
      def range = Mango.from(['one', 'two', 'three']).firstWhere(nothing)

    then:
      range.hasNext() == false
  }

  def "filter nothing"() {
    when:
      def everything = new Predicate<String>() {
        boolean test(String s) { return true; }
      }
      def range = Mango.from(['one', 'two', 'three']).firstWhere(everything)

    then:
      range.hasNext() == true
      range.next() == 'one'
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
      def range = Mango.from(['one', 'two', 'three']).
                       firstWhere(lengthIs3).
                       firstWhere(beginsWithT);

                       def range2 = Mango.from(['one', 'two', 'three', 'tum']).
                       firstWhere(beginsWithT).
                       firstWhere(lengthIs3);

    then:
      range.hasNext() == false
      range2.hasNext() == true
      range2.next() = 'two'
      range2.hasNext() == false
  }
}