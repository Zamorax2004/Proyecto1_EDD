package proyecto_edd;

public class Collectors {

    public static <T> Collector<T, ?, List<T>> toList() {
        return new CollectorImpl<>(
            List::new,
            List::add,
            (left, right) -> { left.addAll(right); return left; }
        );
    }

    public static <T> Collector<T, ?, MySet<T>> toSet() {
        return new CollectorImpl<>(
            MySet::new,
            MySet::add,
            (left, right) -> { left.addAll(right); return left; }
        );
    }

    public static <T, K, U> Collector<T, ?, MyMap<K, U>> toMap(Function<T, K> keyMapper, Function<T, U> valueMapper) {
        return new CollectorImpl<>(
            MyMap::new,
            (map, element) -> map.put(keyMapper.apply(element), valueMapper.apply(element)),
            (left, right) -> { left.putAll(right); return left; }
        );
    }

    // Additional collector methods like joining, groupingBy, partitioningBy can be added here

    // Helper classes and interfaces
    public interface Collector<T, A, R> {
        A supplier();
        void accumulator(A container, T element);
        A combiner(A container1, A container2);
        R finisher(A container);
    }

    private static class CollectorImpl<T, A, R> implements Collector<T, A, R> {
        private final Supplier<A> supplier;
        private final BiConsumer<A, T> accumulator;
        private final BinaryOperator<A> combiner;
        private final Function<A, R> finisher;

        CollectorImpl(Supplier<A> supplier, BiConsumer<A, T> accumulator, BinaryOperator<A> combiner, Function<A, R> finisher) {
            this.supplier = supplier;
            this.accumulator = accumulator;
            this.combiner = combiner;
            this.finisher = finisher;
        }

        @Override
        public A supplier() { return supplier.get(); }

        @Override
        public void accumulator(A container, T element) { accumulator.accept(container, element); }

        @Override
        public A combiner(A container1, A container2) { return combiner.apply(container1, container2); }

        @Override
        public R finisher(A container) { return finisher.apply(container); }
    }

    // Define MyList, MySet, MyMap classes and other necessary functional interfaces
    public static class List<T> {
        // Implementation of MyList
    }

    public static class MySet<T> {
        // Implementation of MySet
    }

    public static class MyMap<K, V> {
        // Implementation of MyMap
    }

    // Functional interfaces
    public interface Supplier<T> {
        T get();
    }

    public interface BiConsumer<T, U> {
        void accept(T t, U u);
    }

    public interface BinaryOperator<T> extends BiConsumer<T, T> {
        T apply(T t1, T t2);
    }

    public interface Function<T, R> {
        R apply(T t);
    }
}