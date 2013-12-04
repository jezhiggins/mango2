package jezuk.mango;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TakeRange<T> extends MangoRangeBase<T> {
  private final Iterator<T> iter_;
  private final Predicate<T> pred_;
  private T next_;
  private boolean continue_;

  TakeRange(final Iterator<T> iterator,
            final Predicate<T> pred) {
    iter_ = iterator;
    pred_ = pred;
    lookAhead();
  } // TakeRange

  public T next() {
    if (!continue_)
      throw new NoSuchElementException();
    final T current = next_;
    lookAhead();
    return current;
  } // next
  public boolean hasNext() { return continue_; }

  private void lookAhead() {
    continue_ = iter_.hasNext();
    if (!continue_)
      return;

    next_ = iter_.next();
    continue_ = pred_.test(next_);
  } // lookAhead
} // TakeRange
