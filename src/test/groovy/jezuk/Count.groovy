package jezuk

import jezuk.mango.Mango

class Count extends spock.lang.Specification {
  def "count"() {
    expect:
    Mango.from(list).count() == result

    where:
    list                  | result
    [1,2,3,4,5,6,7,8,9,0] |   10
    [1,2,3]               |   3
    [1,2,3,4,5]           |   5
    []                    |   0
  }

  def "count after take"() {
    expect:
      Mango.from(list).take(4).count() == result

    where:
      list                  | result
      [1,2,3,4,5,6,7,8,9,0] |   4
      [1,2,3]               |   3
      [1,2,3,4,5]           |   4
      []                    |   0
  }

  def "count after drop"() {
    expect:
    Mango.from(list).drop(4).count() == result

    where:
    list                  | result
    [1,2,3,4,5,6,7,8,9,0] |   6
    [1,2,3]               |   0
    [1,2,3,4,5]           |   1
    []                    |   0
  }

}
