package jezuk.mango;

import java.util.Iterator;
import java.util.List;

public interface MangoRange<T> extends Iterator<T> {
  T next();
  boolean hasNext();
  void remove();

  MangoRange<T> where(final Predicate<T> pred);
  <U> MangoRange<U> select(final Function<T, U> fn);

  public List<T> toList();
  public List<T> to(List<T> list);
} // class MangoRange
