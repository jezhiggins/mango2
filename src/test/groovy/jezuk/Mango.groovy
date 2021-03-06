package jezuk

import jezuk.mango.Mango

class MangoTest extends spock.lang.Specification {
  def "create a MangoRange from a list"() {
    when:
      def range = Mango.from(['one', 'two', 'three'])

    then:
      range != null
  }

  def "iterate over a list"() {
    when:
      def range = Mango.from(['one', 'two', 'three'])

    then:
      range.hasNext() == true
      range.next() == 'one'
      range.hasNext() == true
      range.next() == 'two'
      range.hasNext() == true
      range.next() == 'three'
      range.hasNext() == false
  }

  def "MangoRange is an iterator"() {
    when:
      def range = Mango.from(['one', 'two', 'three'])

    then:
      range instanceof Iterator
  }

  def "put back into a list"() {
    when:
      def range = Mango.from(['one', 'two', 'three'])

    then:
      range.toList() == ['one', 'two', 'three']
  }

  def "MangoRange from array of objects"() {
    when:
      def range = Mango.from('pig', 'pog', 'frog')

    then:
      range.toList() == ['pig', 'pog', 'frog']
  }

  def "empty range"() {
    when: 
      def range = Mango.empty()

    then:
      range.hasNext() == false;
  }
}