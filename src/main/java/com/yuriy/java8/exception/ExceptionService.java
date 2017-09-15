package com.yuriy.java8.exception;

/**
 * Created by Kucya on 06.09.2017.
 */
public class ExceptionService {

    public void checkArgument(final int arg) {
        if (arg < 0) {
            throw new IllegalArgumentException("AAA");
        }
    }
}
