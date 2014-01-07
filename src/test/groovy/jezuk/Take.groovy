package jezuk

import jezuk.mango.Mango

class Take extends spock.lang.Specification {
  def "take tests" () {
    expect:
      Mango.from(s).take(n).toList() == result

    where:
      s                     | n  | result
      [1,2,3,4,5,6,7,8,9,0] | 5  | [1,2,3,4,5]
      [1,2,3]               | 5  | [1,2,3]
      [1,2,3,4,5]           | 5  | [1,2,3,4,5]
      []                    | 5  | []
      [1,2,3,4,5]           | 0  | []
      [1,2,3,4,5]           | 1  | [1]
  }
}