package jezuk.mango;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public abstract class MangoRangeBase<T> implements MangoRange<T> {
  public abstract T next();
  public abstract boolean hasNext();

  public void remove() { throw new UnsupportedOperationException(); }

  public MangoRange<T> where(final Predicate<T> pred) {
    return new WhereRange<T>(this, pred);
  } // where
  public <U> MangoRange<U> select(final Function<T, U> fn) {
    return new SelectRange<T, U>(this, fn);
  } // where
  public MangoRange<T> take(final int count) {
    return new TakeRange<T>(this, Predicates.<T>Counter(count));
  } // take

  public List<T> toList() { return to(new ArrayList<T>()); }
  public List<T> to(final List<T> list) {
    to(Mango.<T>to(list));
    return list;
  } // to
  public void to(final Sink<T> sink) {
    while (hasNext())
      sink.put(next());
  } // to
} // class MangoRange
