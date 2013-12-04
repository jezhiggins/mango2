package jezuk.mango;

import java.util.Iterator;

class StandardRange<T> extends MangoRangeBase<T> {
  private final Iterator<T> iter_;

  StandardRange(final Iterator<T> iterator) {
    iter_ = iterator;
  } // StandardRange

  public T next() { return iter_.next(); }
  public boolean hasNext() { return iter_.hasNext(); }
} // class StandardRange
