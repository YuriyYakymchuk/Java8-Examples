package com.yuriy.vavr;

import com.google.common.base.Strings;
import io.vavr.control.Try;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * Created by Kucya on 15.09.2017.
 */
public class LamdaService {

    public Try<String> functionalMethod(final Supplier<String> supplier) {

        final String result = supplier.get();
        if(Strings.isNullOrEmpty(result)) {
            return Try.failure(new IllegalArgumentException("Empty function"));
        }
        return Try.of(() -> result);
    }
}
