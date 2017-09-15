package com.yuriy.java8.memoization;

import com.google.common.base.Preconditions;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by Kucya on 10.09.2017.
 */
public class RodProfitService {

    final List<Integer> rodPrices;
    final int rodsLength;

    @java.beans.ConstructorProperties({"rodPrices"})
    public RodProfitService(final List<Integer> rodPrices) {
        this.rodPrices = rodPrices;
        this.rodsLength = rodPrices.size();
    }

    public int calculatePriceNotOptimized(final int rodLength) {
        Preconditions.checkArgument(rodLength > 0, "Rod length can't be negative");

        int profit = rodLength <= rodsLength ? rodPrices.get(rodLength - 1) : 0;

        for(int i = 1; i < rodLength; i++) {
            final int combinedProfit = calculatePriceNotOptimized(i) + calculatePriceNotOptimized(rodLength - i);
            if (profit < combinedProfit) {
                profit = combinedProfit;
            }
        }

        return profit;
    }

    public int calculateProfitOptimized(final int rodLength) {
        Preconditions.checkArgument(rodLength < rodsLength, "Price for such length doesn't exist");
        Preconditions.checkArgument(rodLength > 0, "Rod length can't be negative");

        final BiFunction<Function<Integer, Integer>, Integer, Integer> compute =
                (function, length) -> {
                    int profit = (length <= rodsLength) ? rodPrices.get(length - 1) : 0;

                    for (int i = 1; i < length; i++) {
                        int combinedRodPrice = function.apply(i) + function.apply(length - i);

                        if (profit < combinedRodPrice) {
                            profit = combinedRodPrice;
                        }
                    }

                    return profit;
                };
        return Memoizer.callMemoized(compute, rodLength);
    }
}
