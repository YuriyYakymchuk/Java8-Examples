package com.yuriy.java8.exception;

import java.io.IOException;

/**
 * Created by Kucya on 04.09.2017.
 */
public class ExceptionServiceImpl {

    public void calculate(final Function<String, String, IOException> function) {
        try {
            function.accept("aaa");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
