package jezuk.mango;

import java.util.NoSuchElementException;

final class EmptyRange<T> extends MangoRangeBase<T> {
  public T next() { throw new NoSuchElementException("Empty Range!"); }
  public boolean hasNext() { return false; } 
} // class EmptyRange