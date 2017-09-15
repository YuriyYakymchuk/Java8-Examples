package com.yuriy.java8.factorial;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.stream.Stream;

/**
 * Created by Kucya on 09.09.2017.
 */
@FunctionalInterface
public interface FactorialInterface<T> {

    FactorialInterface<T> apply();

    default boolean isComplete() { return false;}

    default T result() { throw new NotImplementedException(); }

    default T invoke() {
        return Stream.iterate(this, FactorialInterface::apply)
                .filter(FactorialInterface::isComplete)
                .findAny()
                .get()
                .result();
    }
}
