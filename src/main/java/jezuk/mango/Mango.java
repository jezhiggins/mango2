package jezuk.mango;

public final class Mango {
  public static <T> MangoRange<T> from(final Iterable<T> source) {
    return new StandardRange<T>(source.iterator());
  } // from

  private Mango() { }
} // class Mango
