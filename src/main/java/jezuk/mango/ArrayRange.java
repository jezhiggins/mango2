package jezuk.mango;

import java.util.NoSuchElementException;

class ArrayRange<T> extends MangoRangeBase<T> {
  private int index_;
  private final T[] array_;

  ArrayRange(final T[] array) {
    array_ = array;
    index_ = 0;
  } // ArrayRange

  public T next() {
    if (!hasNext())
      throw new NoSuchElementException("Source array is exhausted");

    final T cur = array_[index_];
    ++index_;
    return cur;
  } // next
  public boolean hasNext() { return index_ < array_.length; }
}// class ArrayRange
