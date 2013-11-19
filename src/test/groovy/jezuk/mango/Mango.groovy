package jezuk.mango;

class MangoTest extends spock.lang.Specification {
  def "create a MangoRange from a list"() {
    when:
      def range = Mango.from(['one', 'two', 'three'])

    then:
      range != null
  }
}