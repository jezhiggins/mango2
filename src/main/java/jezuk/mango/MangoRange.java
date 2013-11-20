package jezuk.mango;

import java.util.Iterator;

public class MangoRange<T> implements Iterator<T> {
  private final Iterator<T> iter_;

  MangoRange(final Iterator<T> iterator) {
    iter_ = iterator;
  } // MangoRange

  public T next() { return iter_.next(); }
  public boolean hasNext() { return iter_.hasNext(); }
  public void remove() { throw new UnsupportedOperationException(); }
} // class MangoRange
