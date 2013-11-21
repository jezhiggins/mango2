package jezuk.mango;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class StandardRange<T> implements MangoRange<T> {
  private final Iterator<T> iter_;

  StandardRange(final Iterator<T> iterator) {
    iter_ = iterator;
  } // StandardRange

  public T next() { return iter_.next(); }
  public boolean hasNext() { return iter_.hasNext(); }
  public void remove() { throw new UnsupportedOperationException(); }

  public MangoRange<T> where(final Predicate<T> pred) {
    return new WhereRange(this, pred);
  } // where
  public <U> MangoRange<U> select(final Function<T, U> fn) {
    return new SelectRange<T, U>(this, fn);
  } // where

  public List<T> toList() { return to(new ArrayList<T>()); }
  public List<T> to(final List<T> list) {
    while (iter_.hasNext())
      list.add(iter_.next());
    return list;
  } // to
} // class MangoRange
