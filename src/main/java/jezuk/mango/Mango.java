package jezuk.mango;

import java.util.Collection;

public final class Mango {
  public static <T> MangoRange<T> from(final T... sources) {
    return new ArrayRange<T>(sources);
  } // from

  public static <T> MangoRange<T> from(final Iterable<T> source) {
    return new StandardRange<T>(source.iterator());
  } // from

  public static <T> MangoRange<T> from(final Generator<T> source) {
    return new GeneratorRange<T>(source);
  } // from

  public static <T> Sink<T> to(final Collection<T> coll) {
    return new CollectionSink<T>(coll);
  } // to

  private Mango() { }
} // class Mango
