package com.yuriy.java8.exception;

/**
 * Created by Kucya on 04.09.2017.
 */
@FunctionalInterface
public interface Function<T, R, X extends Exception> {

    R accept(T t) throws X;
}
