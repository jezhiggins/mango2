package jezuk.mango;

public final class Predicates {
  public static <T> Predicate<T> Not(Predicate<T> pred) { return new Not<T>(pred); }
  public static <T> Predicate<T> Counter(int count) { return new Counter<T>(count); }

  private static class Not<T> implements Predicate<T> {
    private final Predicate<T> pred_;
    private Not(Predicate<T> pred) { pred_ = pred; }
    public boolean test(T t) { return !pred_.test(t); }
  } // Not

  private static class Counter<T> implements Predicate<T> {
    private final int max_;
    private int count_;
    private Counter(int max) { max_ = max; count_ = 0; }
    public boolean test(T t) { return max_ > count_++; }
  } // class Counter
} // class Predicates
