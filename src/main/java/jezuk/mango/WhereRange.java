package jezuk.mango;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

class WhereRange<T> extends MangoRangeBase<T> {
  private final Iterator<T> iter_;
  private final Predicate<T> pred_;
  private boolean hasNext_;
  private T next_;

  WhereRange(final Iterator<T> iterator,
             final Predicate<T> pred) {
    iter_ = iterator;
    pred_ = pred;
    hasNext_ = true;
    next_ = findNext();
  } // WhereRange

  public T next() {
    final T current_ = next_;
    next_ = findNext();
    return current_;
  } // next
  public boolean hasNext() { return hasNext_; }

  private T findNext() {
    while (iter_.hasNext()) {
      final T next = iter_.next();
      if (pred_.test(next)) 
        return next;
    } // while
    hasNext_ = false;
    return null;
  } // findNext
} // WhereRange
