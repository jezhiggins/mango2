package jezuk.mango;

import java.util.Iterator;

public class MangoRange<T> {
  private final Iterator<T> iter_;

  MangoRange(final Iterator<T> iterator) {
    iter_ = iterator;
  } // MangoRange
} // class MangoRange
