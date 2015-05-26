package jezuk

import jezuk.mango.Mango

class ConcatTest extends spock.lang.Specification {
  def "concat 2 test"() {
    expect:
      Mango.concat(Mango.from(first), Mango.from(second)).toList() == result
      Mango.concat(Mango.from(first)).concat(Mango.from(second)).toList() == result

    where:
      first    | second   | result
      [1]      | [2]      | [1,2]
      [1,2]    | [3]      | [1,2,3]
      [1]      | [2,3]    | [1,2,3]
      [1]      | []       | [1]
      [1,2]    | []       | [1,2]
      []       | [1]      | [1]
      []       | [1,2]    | [1,2]
      []       | []       | []
  }

  def "concat 3 test"() {
    expect:
      Mango.concat(Mango.from(first), Mango.from(second), Mango.from(third)).toList() == result
      Mango.from(first).concat(second).concat(third).toList() == result
      Mango.from(first).concat(second.iterator()).concat(third.iterator()).toList() == result
      Mango.from(first).concat(Mango.from(second).concat(Mango.from(third))).toList() == result

    where:
      first    | second   | third    | result
      [1]      | [2]      | [1,2]    | [1,2,1,2]
      [1,2]    | [3]      | [1,2,3]  | [1,2,3,1,2,3]
      [1]      | [2,3]    | [1,2,3]  | [1,2,3,1,2,3]
      [1]      | []       | [1]      | [1,1]
      [1,2]    | []       | [1,2]    | [1,2,1,2]
      []       | [1]      | [1]      | [1,1]
      []       | [1,2]    | [1,2]    | [1,2,1,2]
      []       | []       | []       | []
  }

  def "concat and distinct"() {
    expect:
      Mango.concat(Mango.from(first), Mango.from(second), Mango.from(third)).distinct().toList() == result

    where:
      first    | second   | third    | result
      [1]      | [2]      | [1,2]    | [1,2]
      [1,2]    | [3]      | [1,2,3]  | [1,2,3]
      [1]      | [2,3]    | [1,2,3]  | [1,2,3]
      [1]      | []       | [1]      | [1]
      [1,2]    | []       | [1,2]    | [1,2]
      []       | [1]      | [1]      | [1]
      []       | [1,2]    | [1,2]    | [1,2]
      []       | []       | []       | []
  }

}