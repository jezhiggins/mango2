package jezuk

import jezuk.mango.Mango
import jezuk.mango.Generator

class MangoGenerate extends spock.lang.Specification {
  def "strings"() {
    when:
      def generator = new Generator<String>() {
        private String s = "";
        String get() { String c = s; s = s + "A"; return c; }
      }
      def range = Mango.from(generator);

    then:
      range.hasNext() == true
      range.next() == ''
      range.hasNext() == true
      range.next() == 'A'
      range.hasNext() == true
      range.next() == 'AA'
      range.hasNext() == true
      range.next() == 'AAA'
      range.hasNext() == true
  }

}