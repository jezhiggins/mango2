package jezuk

import jezuk.mango.Mango
import jezuk.mango.BinaryOperation

class Accumulate extends spock.lang.Specification {
  def summer = new BinaryOperation<Integer>() { 
    public Integer execute(Integer x, Integer y) { return x+y; }
  }

  def "add 1,2,3,4,5"() {
    when:
      def t = Mango.from([1,2,3,4,5]).accumulate(summer);
    then:
      t == 15;
  }

  def "add 1,2,3,4,5 with 10"() {
    when:
      def t = Mango.from([1,2,3,4,5]).accumulate(10, summer);
    then:
      t == 25;
  }

  def "add 1"() {
    when:
      def t = Mango.from([1]).accumulate(summer);
    then:
      t == 1;
  }
}