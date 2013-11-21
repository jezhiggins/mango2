package jezuk.mango;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class WhereRange<T> implements MangoRange<T> {
  private final Iterator<T> iter_;
  private final Predicate<T> pred_;
  private T next_;

  WhereRange(final Iterator<T> iterator,
             final Predicate<T> pred) {
    iter_ = iterator;
    pred_ = pred;
    next_ = findNext();
  } // WhereRange

  public T next() {
    final T current_ = next_;
    next_ = findNext();
    return current_;
  } // next
  public boolean hasNext() { return next_ != null; }
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

  private T findNext() {
    while (iter_.hasNext()) {
      final T next = iter_.next();
      if (pred_.test(next))
        return next;
    } // while
    return null;
  } // findNext
} // WhereRange
