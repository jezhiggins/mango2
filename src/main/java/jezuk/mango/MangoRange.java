package jezuk.mango;

import java.util.Iterator;
import java.util.List;

public interface MangoRange<T> extends Iterator<T> {
  T next();
  boolean hasNext();
  void remove();

  MangoRange<T> where(final Predicate<T> pred);
  MangoRange<T> firstWhere(final Predicate<T> pred);
  <U> MangoRange<U> select(final Function<T, U> fn);
  MangoRange<T> distinct();

  MangoRange<T> take(final int count);
  MangoRange<T> takeWhile(final Predicate<T> pred);
  MangoRange<T> takeUntil(final Predicate<T> pred);

  MangoRange<T> drop(final int count);
  MangoRange<T> dropWhile(final Predicate<T> pred);
  MangoRange<T> dropUntil(final Predicate<T> pred);

  T accumulate(final BinaryOperation<T> accumulator);
  T accumulate(final T initial, final BinaryOperation<T> accumulator);

  long count();

  public List<T> toList();
  public List<T> to(List<T> list);
  public void to(Sink<T> sink);
} // class MangoRange
