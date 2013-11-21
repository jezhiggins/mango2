package jezuk.mango;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class WhereRange<T> extends MangoRangeBase<T> {
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

  private T findNext() {
    while (iter_.hasNext()) {
      final T next = iter_.next();
      if (pred_.test(next))
        return next;
    } // while
    return null;
  } // findNext
} // WhereRange
