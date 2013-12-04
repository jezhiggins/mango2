package jezuk

import jezuk.mango.Mango

class Take extends spock.lang.Specification {
  def "take 5 from 10"() {
    when:
      def l = [1,2,3,4,5,6,7,8,9,0];
      def t = Mango.from(l).take(5).toList()

    then:
       t == [1,2,3,4,5]
  }
  def "take 5 from 3"() {
    when:
      def l = [1,2,3];
      def t = Mango.from(l).take(5).toList()

    then:
       t == [1,2,3]
  }
  def "take 5 from 5"() {
    when:
      def l = [1,2,3,4,5];
      def t = Mango.from(l).take(5).toList()

    then:
       t == [1,2,3,4,5]
  }
  def "take 5 from 0"() {
    when:
      def t = Mango.from([]).take(5).toList()
    then:
       t == []
  }
  def "take 0 from 5"() {
    when:
      def t = Mango.from([1,2,3,4,5]).take(0).toList()
    then:
      t == []
  }
  def "take 1 from 5"() {
    when:
      def t = Mango.from([1,2,3,4,5]).take(1)
    then:
      t.hasNext() == true
      t.next() == 1
      t.hasNext() == false
  }

}