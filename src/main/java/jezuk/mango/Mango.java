package jezuk.mango;

public final class Mango {
  public static <T> MangoRange<T> from(final Iterable<T> source) {
    return new StandardRange<T>(source.iterator());
  } // from

  public static <T> MangoRange<T> from(final Generator<T> source) {
    return new GeneratorRange<T>(source);
  } // from

  private Mango() { }
} // class Mango
