package com.yuriy.java8.map.reduce;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by Kucya on 11.09.2017.
 */
public class StockUtil {

    public static StockInfo getStockInfo(final String name) {
        return new StockInfo(name, YahooFinance.getPrice(name));
    }

    public static Predicate<StockInfo> isPriceHigherThan(final int price) {
        return stockInfo -> stockInfo.getPrice().compareTo(BigDecimal.valueOf(price)) > 0;
    }


    public static StockInfo getHigherStockInfo(final StockInfo first_candidate, final StockInfo second_candidate) {
        return first_candidate.getPrice().compareTo(second_candidate.getPrice()) > 0 ? first_candidate : second_candidate;
    }

    public static StockInfo getLowerStockInfo(final StockInfo first_candidate, final StockInfo second_candidate){
        return first_candidate.getPrice().compareTo(second_candidate.getPrice()) < 0 ? first_candidate : second_candidate;
    }

}
