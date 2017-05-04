## Mango2

Mango2 is a Java iterator and range library.

```java

import jezuk.mango.Mango;

Predicate<String> lengthOf15 = new Predicate<String>() {
  boolean test(String s) { return s.length() >= 15; }q
};

List<String> string = get_a_bunch_of_strings();
List<String> long_strings = Mango.from(strings).where(lengthOf15).toList();


```

Mango2 is range-based version of my earlier [iterator library](https://github/jezhiggins/mango) and was [inspired by talks and articles by Steve Love and Andrei Alexandrescu](http://www.jezuk.co.uk/blog/2013/11/the-forest-road-reader-no-112.html). It is now [effectively obsoleted](http://www.jezuk.co.uk/blog/2013/11/the-forest-road-reader-no-113.html) by Java 8 Streams.
