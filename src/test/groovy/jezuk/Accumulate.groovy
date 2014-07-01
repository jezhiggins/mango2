package jezuk

import jezuk.mango.Mango
import jezuk.mango.BinaryOperation

class Accumulate extends spock.lang.Specification {
  def summer = new BinaryOperation<Integer>() { 
    public Integer execute(Integer x, Integer y) { return x+y; }
  }

  def "adding up"() {
    expect:
      Mango.from(list).accumulate(summer) == total

    where:
      list        || total
      [1]         || 1
      [1,2,3]     || 6
      [1,2,3,4,5] || 15
      []          || null
  }

  def "adding up with seed"() {
    expect:
      Mango.from(list).accumulate(seed, summer) == total

    where:
      list        |seed | total
      [1]         |  10 | 11
      [1,2,3]     |  10 | 16
      [1,2,3,4,5] |   0 | 15
      [1,2,3,4,5] |  10 | 25
      [1,2,3,4,5] |  11 | 26
      [1,2,3,4,5] | -15 |  0
      []          |   0 |  0
      []          |   1 |  1
  }

}