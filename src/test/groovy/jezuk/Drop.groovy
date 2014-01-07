package jezuk

import jezuk.mango.Mango

class Drop extends spock.lang.Specification {
  def "drop tests"() {
    expect:
      Mango.from(list).drop(count).toList() == result

    where:
      list                  | count | result
      [1,2,3,4,5,6,7,8,9,0] |   5   | [6,7,8,9,0]
      [1,2,3]               |   5   | []
      [1,2,3,4,5]           |   5   | []
      []                    |   5   | []
      [1,2,3,4,5]           |   0   | [1,2,3,4,5]
      [1,2,3,4,5]           |   1   | [2,3,4,5]
  }
}