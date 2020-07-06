package monad;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SuperIterable<E> implements Iterable<E> {
  private Iterable<E> self;

  public SuperIterable(Iterable<E> toWrap) {
    self = toWrap;
  }

  public SuperIterable<E> filter(Predicate<E> interesting) {
    List<E> res = new ArrayList<>();
    for (E s : self) {
      if (interesting.test(s)) {
        res.add(s);
      }
    }
    return new SuperIterable(res);
  }

  // "Functor" -- Stream
  public <F> SuperIterable<F> map(Function<E, F> op) {
    List<F> res = new ArrayList<>();
      self.forEach(e -> res.add(op.apply(e)));
//    for (E s : self) {
//      res.add(op.apply(s));
//    }
    return new SuperIterable(res);
  }

  // "Monad" -- Stream
  public <F> SuperIterable<F> flatMap(Function<E, SuperIterable<F>> op) {
    List<F> res = new ArrayList<>();
    for (E s : self) {
      op.apply(s).forEach(f -> res.add(f));
    }
    return new SuperIterable(res);
  }

  // Iterable.forEach
//  public void forEvery(Consumer<E> op) {
//    for (E e : self) {
//      op.accept(e);
//    }
//  }
  @Override
  public Iterator<E> iterator() {
    return self.iterator();
  }
}
