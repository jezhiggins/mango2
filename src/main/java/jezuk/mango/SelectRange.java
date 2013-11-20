package jezuk.mango;

import java.util.Iterator;

public class SelectRange<T, U> implements Iterator<U> {
  private final Iterator<T> iter_;
  private final Function<T, U> fn_;

  SelectRange(final Iterator<T> iterator,
              final Function<T, U> fn) {
    iter_ = iterator;
    fn_ = fn;
  } // SelectRange

  public U next() { return fn_.apply(iter_.next()); }
  public boolean hasNext() { return iter_.hasNext(); }
  public void remove() { throw new UnsupportedOperationException(); }

  public WhereRange<U> where(final Predicate<U> pred) {
    return new WhereRange(this, pred);
  } // where
  public <Y> SelectRange<U, Y> select(final Function<U, Y> fn) {
    return new SelectRange(this, fn);
  } // where
} // SelectRange
