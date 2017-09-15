package com.yuriy.java8.lazy;

import java.util.function.Supplier;

/**
 * Created by Kucya on 07.09.2017.
 */
public class Evaluator {

    public static boolean evaluate(final int i) {
        System.out.println("Evaluate int value " + i);
        return i > 0;
    }

    public static boolean lazyEvaluation(final Supplier<Boolean> arg1, final Supplier<Boolean> arg2) {
        System.out.println(arg2.get());
        System.out.println("Eager evaluation");
        return (arg1.get() && arg2.get());
    }

    public static boolean lazyEvaluation(final Boolean arg1, final Boolean arg2) {
        System.out.println(arg2);
        System.out.println(arg2);
        System.out.println(arg2);
        System.out.println("Eager evaluation");
        return (arg1 && arg2);
    }
}
