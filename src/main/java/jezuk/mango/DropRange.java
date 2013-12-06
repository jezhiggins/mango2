package jezuk.mango;

import java.util.Iterator;
import java.util.NoSuchElementException;

class DropRange<T> extends MangoRangeBase<T> {
  private final Iterator<T> iter_;
  private final Predicate<T> pred_;
  private T next_;
  private boolean hasNext_;

  DropRange(final Iterator<T> iterator,
            final Predicate<T> pred) {
    iter_ = iterator;
    pred_ = pred;
    windOn();
  } // DropRange

  public T next() {
    if (!hasNext_)
      throw new NoSuchElementException();

    T current = next_;
    advance();
    return current;
  } // next
  public boolean hasNext() { return hasNext_; }

  private void advance() {
    hasNext_ = iter_.hasNext();
    if (hasNext_)
      next_ = iter_.next();
  } // advance

  private void windOn() {
    do {
      advance();
      if ((hasNext_) && (!pred_.test(next_)))
        return;
    } while(hasNext_);
  } // windOn
} // DropRange
