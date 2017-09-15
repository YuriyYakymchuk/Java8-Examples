package com.yuriy.java8.resource.management;

import java.io.IOException;

/**
 * Created by Kucya on 06.09.2017.
 */
@FunctionalInterface
public interface TransactionFunction<T, R, X extends IOException> {
    R accept(T t) throws X;
}
