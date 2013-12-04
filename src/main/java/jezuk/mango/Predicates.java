package jezuk.mango;

public final class Predicates {
  public static <T> Predicate<T> Counter(int count) {
    return new Counter<T>(count);
  } // Counter

  private static class Counter<T> implements Predicate<T> {
    private final int max_;
    private int count_;
    private Counter(int max) { max_ = max; count_ = 0; }
    public boolean test(T o) { return max_ > count_++; }
  } // class Counter
} // class Predicates
