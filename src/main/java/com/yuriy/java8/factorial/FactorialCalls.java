package com.yuriy.java8.factorial;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Kucya on 09.09.2017.
 */
public class FactorialCalls {

    public static <T> FactorialInterface<T> call(final FactorialInterface<T> nextValue) {
        return nextValue;
    }

    public static <T> FactorialInterface<T> done(final T value) {
        return new FactorialInterface<T>() {
            @Override
            public boolean isComplete() {
                return true;
            }

            @Override
            public T result() {
                return value;
            }

            @Override
            public FactorialInterface<T> apply() {
                throw new NotImplementedException();
            }
        };
    }
}
