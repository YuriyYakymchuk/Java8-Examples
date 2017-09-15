package com.yuriy.java8.memoization;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by Kucya on 10.09.2017.
 */
public class Memoizer {

    public static <T,R> R callMemoized(final BiFunction<Function<T, R>, T, R> function, T input) {
        final Function<T, R> memorized = new Function<T, R>() {
            private final Map<T, R> cachedProfits = new HashMap<>();

            @Override
            public R apply(T t) {
                return cachedProfits.computeIfAbsent(t, key -> function.apply(this, key));
            }
        };
        return memorized.apply(input);
    }
}
