package com.yuriy.java8.lazy;

import java.util.function.Supplier;

/**
 * Created by Kucya on 08.09.2017.
 */
public class FibonacciService {

    private int currentFibonacci;

    public static int generateFibonacci(int from) {
      return from + ++from;
    }

    public static int getValue() {
        return 120;
    }
}
