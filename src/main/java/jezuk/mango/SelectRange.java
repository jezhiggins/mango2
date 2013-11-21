package jezuk.mango;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class SelectRange<T, U> implements MangoRange<U> {
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

  public MangoRange<U> where(final Predicate<U> pred) {
    return new WhereRange(this, pred);
  } // where
  public <Y> MangoRange<Y> select(final Function<U, Y> fn) {
    return new SelectRange<U, Y>(this, fn);
  } // where

  public List<U> toList() { return to(new ArrayList<U>()); }
  public List<U> to(final List<U> list) {
    while (hasNext())
      list.add(next());
    return list;
  } // to
} // SelectRange
