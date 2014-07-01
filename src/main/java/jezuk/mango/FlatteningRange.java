package jezuk.mango;

import java.util.NoSuchElementException;

final class FlatteningRange<T> extends MangoRangeBase<T> {
  private int index_;
  private final MangoRange<? extends T>[] ranges_;

  FlatteningRange(final MangoRange<? extends T>[] ranges) {
    ranges_ = ranges;
    index_ = 0;
  } // FlatteningRange

  public T next() {
    if (hasNext())
      return ranges_[index_].next();    
    throw new NoSuchElementException("Ranges are exhausted.");
  } // next

  public boolean hasNext() { 
    if (index_ == ranges_.length) 
      return false;

    if (ranges_[index_].hasNext())
      return true;

    ++index_;
    return hasNext();
  } // hasNext
} // class FlatteningRange
 

   