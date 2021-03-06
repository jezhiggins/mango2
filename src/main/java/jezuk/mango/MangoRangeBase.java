package jezuk.mango;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

abstract class MangoRangeBase<T> implements MangoRange<T> {
  public abstract T next();
  public abstract boolean hasNext();

  public void remove() { throw new UnsupportedOperationException(); }

  public MangoRange<T> where(final Predicate<T> pred) {
    return new WhereRange<T>(this, pred);
  } // where
  public <U> MangoRange<U> select(final Function<T, U> fn) {
    return new SelectRange<T, U>(this, fn);
  } // where
  public MangoRange<T> distinct() {
    return new WhereRange<T>(this, new Predicate<T>() {
      private Set<T> seen = new HashSet<T>();
      public boolean test(T value) {
        return seen.add(value);
      }
    });
  } // distinct
  public MangoRange<T> first() {
    return take(1);
  } // first
  public MangoRange<T> firstWhere(final Predicate<T> pred) {
    return where(pred).take(1);
  } // where
  public MangoRange<T> last() {
    if (!hasNext())
      return Mango.empty();

    T l = next();
    while (hasNext())
      l = next();
    return Mango.from(l);
  } // last
  public MangoRange<T> lastWhere(final Predicate<T> pred) {
    return where(pred).last();
  } // lastWhere

  public MangoRange<T> take(final int count) {
    return takeWhile(Predicates.<T>Counter(count));
  } // take
  public MangoRange<T> takeWhile(final Predicate<T> pred) {
    return new TakeRange<T>(this, pred);
  } // takeWhile
  public MangoRange<T> takeUntil(final Predicate<T> pred) {
    return takeWhile(Predicates.Not(pred));
  } // takeUntil

  public MangoRange<T> drop(final int count) {
    return dropWhile(Predicates.<T>Counter(count));
  } // drop
  public MangoRange<T> dropWhile(final Predicate<T> pred) {
    return new DropRange<T>(this, pred);
  } // dropWhile
  public MangoRange<T> dropUntil(final Predicate<T> pred) {
    return dropWhile(Predicates.Not(pred));
  } // dropUntil

  public MangoRange<T> concat(final Iterator<T> iterator) {
    return Mango.concat(this, Mango.from(iterator));
  } // concat
  public MangoRange<T> concat(final Iterable<T> iterable) {
    return Mango.concat(this, Mango.from(iterable));
  } // concat
  public MangoRange<T> concat(final MangoRange<T> range) {
    return Mango.concat(this, range);
  } // concat

  public T accumulate(final BinaryOperation<T> accumulator) {
    if (!hasNext())
      return null;
    return accumulate(next(), accumulator);
  } // accumulate
  public T accumulate(final T initial, final BinaryOperation<T> accumulator) {
    T acc = initial;
    while (hasNext())
      acc = accumulator.execute(acc, next());
    return acc;
  } // accumulate

  public long count() {
    long c = 0;
    while (hasNext()) {
      ++c;
      next();
    } // while
    return c;
  } // count

  public boolean allMatch(final Predicate<T> pred) {
    if (!hasNext())
      return false;

    while (hasNext())
      if (!pred.test(next()))
        return false;

    return true;
  } // allMatch

  public boolean anyMatch(final Predicate<T> pred) {
    if (!hasNext())
      return false;

    while (hasNext())
      if (pred.test(next()))
        return true;

    return false;
  } // anyMatch

  public boolean noneMatch(final Predicate<T> pred) {
    if (!hasNext())
      return true;

    while (hasNext())
      if (pred.test(next()))
        return false;

    return true;
  } // noneMatch

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
