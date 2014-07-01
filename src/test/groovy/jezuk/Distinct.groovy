package jezuk

import jezuk.mango.Mango

class Distinct extends spock.lang.Specification {
  def "distinct"() {
    expect:
      Mango.from(list).distinct().toList() == distinctList

    where:
      list            || distinctList
      [0,1,2,3,4]     || [0,1,2,3,4]
      [0,1,2,2,2]     || [0,1,2]
      [0,1,2,3,2]     || [0,1,2,3]
      [0,1,2,1,2]     || [0,1,2]
      [0,1,2,2,1]     || [0,1,2]
      ['a','b','c']   || ['a','b','c']
      ['a','a','c']   || ['a','c']
      ['a','b','a']   || ['a','b']
      ['a',null,'c']  || ['a',null,'c']
      [null,'b',null] || [null,'b']
      [null,null,'b'] || [null,'b']
  }
}