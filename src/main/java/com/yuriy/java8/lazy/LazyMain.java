package com.yuriy.java8.lazy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.yuriy.java8.lazy.Evaluator.evaluate;
import static com.yuriy.java8.lazy.FibonacciService.getValue;

/**
 * Created by Kucya on 07.09.2017.
 */
public class LazyMain {

    public static void main(String[] args) {
        List<Integer> fibonacciValues = Stream.iterate(10, FibonacciService::generateFibonacci).limit(3)
                .collect(Collectors.<Integer>toList());
        final int i = 1;
        final int k = 1;
        final List<Integer> generatedValues = Stream.generate(() -> {return i + k;}).limit(3).collect(Collectors.toList());
        System.out.println("Fibonacci values: " + fibonacciValues);
        System.out.println("Generated values: " + generatedValues);
    }

    public static void lazyCreationAndEvaluation() {
        final HeavyObjectHolder heavyObjectHolder = new HeavyObjectHolder();

        System.out.println(heavyObjectHolder.getHeavyObject().getHeavyField());

        System.out.println(Evaluator.lazyEvaluation(() -> evaluate(-1), () -> evaluate(-5)));
        Evaluator.lazyEvaluation(evaluate(-1), evaluate(3));
    }
}
