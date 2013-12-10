package jezuk.mango;

public interface BinaryFunction<T, U, R> {
  R execute(T x, U y);
}