package jezuk.mango;

class GeneratorRange<T> extends MangoRangeBase<T> {
  private final Generator<T> gen_;

  GeneratorRange(final Generator<T> gen) {
    gen_ = gen;
  } // GeneratorRange

  public T next() { return gen_.get(); }
  public boolean hasNext() { return true; }
} // GeneratorRange
