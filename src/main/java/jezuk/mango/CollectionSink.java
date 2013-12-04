package jezuk.mango;

import java.util.Collection;

public final class CollectionSink<T> implements Sink<T> {
  private final Collection<T> coll_;

  public CollectionSink(final Collection<T> coll) {
    coll_ = coll;
  } // CollectionSink

  @Override
  public void put(final T t) {
    coll_.add(t);
  } // put
} // CollectionSink
