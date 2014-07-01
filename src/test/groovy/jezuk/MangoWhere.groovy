package jezuk

import jezuk.mango.Mango
import jezuk.mango.Predicate

class MangoWhere extends spock.lang.Specification {
  def "filter a list"() {
    given:
      def findTwo = new Predicate<String>() {
        boolean test(String s) { return 'two' == s; }
      }

    expect:
      Mango.from(list).where(findTwo).toList() == result

    where:
      list                    | result
      ['one', 'two', 'three'] | ['two']
      ['one', 'three']        | []
      []                      | []
      ['one']                 | []
      ['one', 'two', 'two']   | ['two', 'two']
  }

  def "filter everything"() {
    given:
      def nothing = new Predicate<String>() {
        boolean test(String s) { return false; }
      }

    expect:
      Mango.from(list).where(nothing).toList() == result

    where:
      list                    | result
      ['one', 'two', 'three'] | []
      ['one', 'three']        | []
      []                      | []
      ['one']                 | []
  }

  def "filter nothing"() {
    given:
      def everything = new Predicate<String>() {
        boolean test(String s) { return true; }
      }

    expect:
      Mango.from(list).where(everything).toList() == result

    where:
      list                       | result
      ['one', 'two', 'three']    | ['one', 'two', 'three'] 
      ['one', 'three']           | ['one', 'three']
      []                         | []
      ['one']                    | ['one']
      [null]                     | [null]
      [null, null]               | [null, null]
      ['one', null, 'two', null] | ['one', null, 'two', null]
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
                       where(lengthIs3).
                       where(beginsWithT);

    then:
      range.hasNext() == true
      range.next() == 'two'
      range.hasNext() == false
  }
}