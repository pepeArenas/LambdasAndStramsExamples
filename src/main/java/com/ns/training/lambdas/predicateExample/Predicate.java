package com.ns.training.lambdas.predicateExample;

public interface Predicate<T> {

    boolean test(T t);

    /**
     * other represent the min predicate on the calling
     * test alone represent the object itself in this case max of the calling side
     * so we are saying that max and min should be true
     * max.and(min); if we want to refer to max is the test itself
     * max.and(min); if we want to refer to the min is other.min
     */
    default Predicate<T> and(Predicate<T> other) {
        return t -> test(t) && other.test(t);
    }

    default Predicate<T> or(Predicate<T> other) {
        return t -> test(t) || other.test(t);
    }

    /**
     * When we code a static method is not be T that represent an instance, it will be for example U and is global for
     * all instances
     */
    static <U> Predicate<U> isEqualsTo(U u) {
        return s -> s.equals(u);
    }
}
