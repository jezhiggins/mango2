package jezuk.mango;

public final class Predicates {
  public static <T> Predicate<T> Not(Predicate<T> pred) { return new Not<T>(pred); }
  public static <T> Predicate<T> Counter(int count) { return new Counter<T>(count); }
  public static <T> Predicate<T> Equal(T value) { return value != null ? new Equal<T>(value) : new IsNull<T>(); }
  public static <T> Predicate<T> NotEqual(T value) { return value != null ? new NotEqual<T>(value) : new IsNotNull<T>(); }
  public static <T> Predicate<T> Null() { return new IsNull<T>(); }
  public static <T> Predicate<T> NotNull() { return new IsNotNull<T>(); }

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

  private static class Equal<T> implements Predicate<T> {
    private final T value_;
    private Equal(T value) { value_ = value; }
    public boolean test(T t) { return value_.equals(t); }
  } // class Equal

  private static class NotEqual<T> implements Predicate<T> {
    private final T value_;
    private NotEqual(T value) { value_ = value; }
    public boolean test(T t) { return !value_.equals(t); }
  } // class NotEqual

  private static class IsNull<T> implements Predicate<T> {
    public boolean test(T t) { return t == null; }
  } // class IsNull

  private static class IsNotNull<T> implements Predicate<T> {
    public boolean test(T t) { return t != null; }
  } // class IsNotNull
} // class Predicates
