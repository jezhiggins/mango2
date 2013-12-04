package jezuk.mango;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

class SelectRange<T, U> extends MangoRangeBase<U> {
  private final Iterator<T> iter_;
  private final Function<T, U> fn_;

  SelectRange(final Iterator<T> iterator,
              final Function<T, U> fn) {
    iter_ = iterator;
    fn_ = fn;
  } // SelectRange

  public U next() { return fn_.apply(iter_.next()); }
  public boolean hasNext() { return iter_.hasNext(); }
} // SelectRange
