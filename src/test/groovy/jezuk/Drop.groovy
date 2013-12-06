package jezuk

import jezuk.mango.Mango

class Drop extends spock.lang.Specification {
  def "drop 5 from 10"() {
    when:
      def t = dropFrom(5, [1,2,3,4,5,6,7,8,9,0])
    then:
      t == [6,7,8,9,0]
  }
  def "drop 5 from 3"() {
    when:
      def t = dropFrom(5, [1,2,3])
    then:
       t == []
  }
  def "drop 5 from 5"() {
    when:
      def t = dropFrom(5, [1,2,3,4,5])
    then:
       t == []
  }
  def "drop 5 from 0"() {
    when:
      def t = dropFrom(5, [])
    then:
       t == []
  }
  def "drop 0 from 5"() {
    when:
      def t = dropFrom(0, [1,2,3,4,5])
    then:
      t == [1,2,3,4,5]
  }
  def "drop 1 from 5"() {
    when:
      def t = dropFrom(1, [1,2,3,4,5])
    then:
      t == [2,3,4,5]
  }

  def dropFrom(def count, def list) {
    return Mango.from(list).drop(count).toList()
  }
}