package com.yuriy.java8.memoization;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Kucya on 10.09.2017.
 */
public class RodMain {

    private static List<Integer> rodsPrices = Arrays.asList(1,2,3,1,2,6,12,1,6,4, 1, 2, 1, 1, 3, 1, 4, 5, 2,1 ,3, 4, 2, 3, 1, 2);
    private static RodProfitService rodProfitService = new RodProfitService(rodsPrices);

    private static final int rodLength = 20;

    public static void main(String[] args) {
        calculateProfitNotOptimized();

        calculateProfitOptimized();
    }

    private static void calculateProfitNotOptimized() {

        final long calculationStart = System.currentTimeMillis();

        final int rodPrice = rodProfitService.calculatePriceNotOptimized(rodLength);

        System.out.println(String.format("Execution time of not optimized method is: %d ms", System.currentTimeMillis() - calculationStart));

        System.out.println(String.format("Rod profit of length %d is %d", rodLength, rodPrice));
    }

    private static void calculateProfitOptimized() {
        final long calculationStart = System.currentTimeMillis();

        final int rodPrice = rodProfitService.calculateProfitOptimized(rodLength);

        System.out.println(String.format("Execution time of optimized method is: %d ms", System.currentTimeMillis() - calculationStart));

        System.out.println(String.format("Rod profit of length %d is %d", rodLength, rodPrice));
    }
}
